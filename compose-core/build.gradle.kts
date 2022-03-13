import com.sophimp.plugin.Dep

plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
    signing
    id("sophimp-publish")
}

android {
    compileSdk = Dep.SdkVersion.compileSdkVersion

    buildFeatures {
        compose = true
    }

    defaultConfig {
        minSdk = Dep.SdkVersion.minSdkVersion
        targetSdk = Dep.SdkVersion.targetSdkVersion
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

    composeOptions {
        kotlinCompilerExtensionVersion = Dep.AndroidX.Compose.version
    }
}

dependencies {
    api(Dep.AndroidX.annotation)
    api(Dep.AndroidX.CommonLib.appCompat)
    api(Dep.AndroidX.coreKtx)
    api(Dep.AndroidX.Compose.ui)
    api(Dep.AndroidX.Compose.animation)
    api(Dep.AndroidX.Compose.material)
    api(Dep.AndroidX.Compose.compiler)
    api(Dep.AndroidX.Compose.constraintLayout)
}