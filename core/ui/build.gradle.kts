plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply<AndroidDefault>()

dependencies {
    uiModule(true)
}