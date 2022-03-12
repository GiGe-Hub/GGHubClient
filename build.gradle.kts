// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.sophimp.plugin.Dep
buildscript {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }

}

plugins {
    id("sophimp-dep")
}

subprojects {
    group = Dep.DepPlug.group
}

//allprojects {
//    repositories {
//        mavenCentral()
//        google()
//        mavenLocal()
//    }
//}
