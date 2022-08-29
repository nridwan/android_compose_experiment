plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply(from = "$rootDir/android_default.gradle.kts")

dependencies {
    uiModule(true)
}