buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.19")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}