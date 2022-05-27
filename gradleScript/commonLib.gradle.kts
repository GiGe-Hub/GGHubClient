/**
 * 简单抽取这个gradle 感觉没有意义, 创建模块的工作并不频繁, 有删除替换的工夫, 直接复制粘贴也做了, 保证版本统一即可.
 * 创建在这里暂留作模板吧.
 */
import com.sophimp.plugin.Dep

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    `maven-publish`
    signing
    id("sophimp-publish")
    id("dagger.hilt.android.plugin")
}
//apply plugin: 'com.android.library'
//apply plugin: 'kotlin-android'
//apply plugin: 'kotlin-kapt'
//apply plugin: 'dagger.hilt.android.plugin'
android {
    compileSdk = Dep.SdkVersion.compileSdkVersion
    buildToolsVersion = Dep.SdkVersion.buildToolsVersion

    defaultConfig {
        minSdk = Dep.SdkVersion.minSdkVersion
        targetSdk = Dep.SdkVersion.targetSdkVersion
        versionCode = Dep.SdkVersion.versionCode
        versionName = Dep.SdkVersion.versionName
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = Dep.SdkVersion.javaVersion
        targetCompatibility = Dep.SdkVersion.javaVersion
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
//            signingConfig = signingConfigs.getByName("release")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        correctErrorTypes = true
    }

    // 将每个模块分成sdk 和 source两个部分, 暂时仅仅是从约定与业务上做封装隔离, 后续看情况再做插件, 使用工具来约束
    sourceSets.getByName("main") {
        java.srcDir("src/main/java")
        java.srcDir("src/main/sdk")
    }

    buildFeatures {
        viewBinding = true
//        compose true
        // Disable unused AGP features
        buildConfig = false
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }
}

dependencies {
//    implementation (fileTree(dir: 'libs', include: ['*.jar'])
//    implementation(Dep.Libs.Kotlin.stdlib)
//    implementation(Libs.Coroutines.android)
//    implementation(Libs.AndroidX.CmdUI.appCompat)
//
//    implementation(Libs.AndroidX.coreKtx)
//    implementation(Libs.Themes.material)
//    implementation(Libs.AndroidX.VectorDrawable.vectorDrawable)
//    implementation(Libs.AndroidX.VectorDrawable.vectorDrawableAnimation)
//
//    implementation(Libs.Timber.timber)
//
//    implementation(Libs.TabLayout.dslAdapter)
//
//    implementation(Libs.ThirdLib.searchView)
//
//    implementation(Libs.Dagger2.hiltAndroid)
//    kapt(Libs.Dagger2.hiltCompiler)
//
//    androidTestImplementation(Libs.JUnit.junit)
//    androidTestImplementation(Libs.AndroidX.Test.core)
//    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
//    androidTestImplementation(Libs.AndroidX.Test.rules)
//    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
}
