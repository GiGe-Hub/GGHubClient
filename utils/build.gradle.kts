import com.sophimp.plugin.Dep

plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
    signing
    id("sophimp-publish")
}

//version = Dep.QMUI.photoVer

android {
    compileSdk = Dep.SdkVersion.compileSdkVersion

    defaultConfig {
        minSdk = Dep.SdkVersion.minSdkVersion
        targetSdk = Dep.SdkVersion.targetSdkVersion
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dep.AndroidX.Compose.version
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = Dep.SdkVersion.javaVersion
        targetCompatibility = Dep.SdkVersion.javaVersion
    }
    kotlinOptions {
        jvmTarget = Dep.SdkVersion.kotlinJvmTarget
    }
}

dependencies {

    implementation(Dep.ThirdLib.mmkv)

}