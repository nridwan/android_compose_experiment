plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("kotlin-parcelize")

    id("com.google.protobuf")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.nridwan.compose"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Libraries.coreKtx)
    implementation(Libraries.composeUi)
    implementation("androidx.compose.material:material:${Versions.composeVersion}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.5.1")

    // accompanist
    implementation("com.google.accompanist:accompanist-pager:${Versions.accompanistVersion}")
    implementation("com.google.accompanist:accompanist-pager-indicators:${Versions.accompanistVersion}")
    implementation("com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanistVersion}")
    implementation("com.google.accompanist:accompanist-drawablepainter:${Versions.accompanistVersion}")
    implementation("com.google.accompanist:accompanist-flowlayout:${Versions.accompanistVersion}")
    implementation("com.google.accompanist:accompanist-permissions:${Versions.accompanistVersion}")

    // Lifecycle libraries
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycleVersion}")
    implementation("androidx.lifecycle:lifecycle-common:${Versions.lifeCycleVersion}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycleVersion}")

    implementation("androidx.work:work-runtime-ktx:2.7.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.43.2")
    kapt("com.google.dagger:hilt-compiler:2.43.2")
    implementation("androidx.hilt:hilt-work:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    // Proto Data Store
    implementation("androidx.datastore:datastore:1.0.0")
    implementation("com.google.protobuf:protobuf-javalite:3.21.5")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.composeVersion}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}")
}