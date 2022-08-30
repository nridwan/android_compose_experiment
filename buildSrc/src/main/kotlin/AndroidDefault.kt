import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

class AndroidDefault : Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.getByName("android")
        if (extension is BaseExtension) {
            extension.apply {

                defaultConfig {
                    minSdk = 21
                    targetSdk = 32

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
                if(this is BaseAppModuleExtension) {
                    compileSdk = 32
                    buildFeatures {
                        compose = true
                    }
                }
                if(this is LibraryExtension) {
                    compileSdk = 32
                    buildFeatures {
                        compose = true
                    }
                }
                val kotlinOptions = (this as ExtensionAware).extensions.getByName("kotlinOptions")
                if(kotlinOptions is KotlinJvmOptions) {
                    kotlinOptions.apply {
                        jvmTarget = "1.8"
                    }
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
        }
        //you could even add common dependencies here
    }
}