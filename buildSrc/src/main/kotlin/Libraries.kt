import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Libraries {
    const val coreKtx = "androidx.core:core-ktx:1.8.0"
}

fun DependencyHandler.uiPack() {
    implementation("androidx.compose.ui:ui:${Versions.compose}")
    implementation("androidx.compose.material:material:${Versions.compose}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Versions.compose}")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("androidx.navigation:navigation-runtime:2.5.1")
    debugImplementation("androidx.customview:customview:1.2.0-alpha01")
    debugImplementation("androidx.customview:customview-poolingcontainer:1.0.0-alpha01")
}

fun DependencyHandler.accompanist() {
    implementation("com.google.accompanist:accompanist-pager:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-pager-indicators:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-drawablepainter:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-permissions:${Versions.accompanist}")
}

fun DependencyHandler.ktx() {
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}")
    implementation("androidx.lifecycle:lifecycle-common:${Versions.lifeCycle}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}")
    implementation("androidx.work:work-runtime-ktx:2.7.1")
}

fun DependencyHandler.coroutines() {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
}

fun DependencyHandler.hilt() {
    implementation("com.google.dagger:hilt-android:2.43.2")
    implementation("androidx.hilt:hilt-work:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("com.google.dagger:hilt-compiler:2.43.2")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
}

fun DependencyHandler.proto() {
    implementation("androidx.datastore:datastore:1.0.0")
    implementation("com.google.protobuf:protobuf-javalite:3.21.5")
}

fun DependencyHandler.retrofit() {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
}

fun DependencyHandler.testDependency() {
    testImplementation("junit:junit:4.13.2")
}

fun DependencyHandler.completeTestDependency() {
    testDependency()
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.compose}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.compose}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${Versions.compose}")
}

fun DependencyHandler.uiModule(withCore: Boolean = false) {
    if(withCore) implementation(Libraries.coreKtx)
    uiPack()
    accompanist()
    ktx()
    completeTestDependency()
}

fun DependencyHandler.featureModule(withCore: Boolean = false) {
    uiModule(withCore)
    coroutines()
    hilt()
    implementation(project(Modules.coreUi))
}

fun DependencyHandler.implementation(depName: Any) {
    add("implementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

private fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}