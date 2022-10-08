package com.subpm

import com.subpm.model.PackageList
import com.subpm.model.SubpkgOption
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import java.io.File
import java.io.FileInputStream
import java.io.InputStream


abstract class SubPM : DefaultTask() {
    @get:Input
    abstract val actionType: Property<String>

    init {
        actionType.convention("hello from GreetingTask")
    }

    @TaskAction
    fun act() {
        val cwd = System.getProperty("user.dir")
        val subpkgOption = SubpkgOption()
        val yaml = Yaml(Constructor(PackageList::class.java))
        val res = PackageList()
        try {
            for (path in subpkgOption.subpkgs) {
                val file = File("$cwd/$path")
                if (file.exists()) {
                    val targetStream: InputStream = FileInputStream(file)
                    res.merge(yaml.load(targetStream))
                } else if (!path.contains(".local")) {
                    println("File $path not found")
                }
            }
            val clone = when(actionType.get()) {
                "update" -> false
                else -> true
            }
            res.packages.forEach { (path: String?, url: String?) ->
                clonePackage(File(cwd), path, url, clone)
            }
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

    private fun clonePackage(cwd: File, path: String, url: String?, clone: Boolean) {
        if (url == null) return
        val urlParts = url.split("#").toTypedArray()
        val file = File(cwd, path)
        if (!file.exists() && clone) {
            try {
                val builder = ProcessBuilder("git", "clone", urlParts[0], path)
                builder.redirectErrorStream(true)
                builder.redirectInput(ProcessBuilder.Redirect.INHERIT)
                builder.redirectOutput(ProcessBuilder.Redirect.INHERIT)
                builder.directory(cwd)
                val process = builder.start()
                process.waitFor()
            } catch (t: Throwable) {
                t.printStackTrace()
                return
            }
        }
        if (!file.exists()) {
            println("Error, subpackage $path ($url) cannot be resolved")
            return
        }
        if (urlParts.size > 1) {
            checkoutPkg(file, path, urlParts[1])
        }
    }

    private fun checkoutPkg(cwd: File, path: String, hash: String) {
        try {
            val builder = ProcessBuilder("git", "checkout", hash)
            builder.redirectErrorStream(true)
            builder.redirectInput(ProcessBuilder.Redirect.INHERIT)
            builder.directory(cwd)
            val process = builder.start()
            process.waitFor()
        } catch (t: Throwable) {
            t.printStackTrace()
            return
        }
        try {
            val builder = ProcessBuilder("git", "pull")
            builder.redirectErrorStream(true)
            builder.redirectInput(ProcessBuilder.Redirect.INHERIT)
            builder.directory(cwd)
            val process = builder.start()
            process.waitFor()
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }
}