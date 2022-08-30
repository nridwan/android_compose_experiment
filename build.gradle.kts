buildscript {
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.google.protobuf") version "0.8.18" apply false
    id("com.google.dagger.hilt.android") version "2.43.2" apply false
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}