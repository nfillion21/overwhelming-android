buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}")
        classpath ("com.google.gms:google-services:${Versions.googleServices}")
    }
}

plugins {
    id("com.android.application") version "7.1.2" apply false
    id("com.android.library") version "7.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.5.21" apply false
}
tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
