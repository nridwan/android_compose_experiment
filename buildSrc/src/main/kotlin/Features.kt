import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Features {
    const val auth = ":feat:auth:lib"
    const val home = ":feat:home:lib"
}

fun DependencyHandler.allFeatures() {
    implementation(project(Features.auth))
    implementation(project(Features.home))
}