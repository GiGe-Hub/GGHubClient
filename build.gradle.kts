// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.sophimp.plugin.Dep

buildscript {

    dependencies {
        classpath("com.android.tools.build:gradle:7.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
    }

}

plugins {
    id("sophimp-dep")
    id("com.android.library") version "7.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
//    id("com.android.library") version "7.1.2" apply false
//    id("org.jetbrains.kotlin.android") version "1.5.30" apply false
}

subprojects {
    group = Dep.DepPlug.group
}