
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("kotlin-parcelize")

    id("com.google.protobuf")
}
apply<AndroidDefault>()

android {
    defaultConfig {
        applicationId = "com.nridwan.compose"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    featureModule(true)
    proto()
    retrofit()
    allFeatures()
}