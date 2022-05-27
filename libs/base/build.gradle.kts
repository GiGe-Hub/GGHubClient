import com.sophimp.plugin.Dep

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}
//apply plugin: 'dagger.hilt.android.plugin'

//apply(from = rootProject.file("./gradleScript/commonLib.gradle.kts"))
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

    implementation(Dep.TabLayout.dslAdapter)

    api(Dep.Timber.timber)
    api(Dep.ThirdLib.mmkv)
    api(Dep.AndroidX.swipeRefreshLayout)
    api(Dep.AndroidX.CommonLib.appCompat)
    api(Dep.AndroidX.coreKtx)
    api(Dep.Themes.material)
    api(Dep.AndroidX.VectorDrawable.vectorDrawable)
    api(Dep.AndroidX.VectorDrawable.vectorDrawableAnimation)

    implementation(Dep.ThirdLib.jsch)
//    implementation(Dep.ThirdLib.commonIO)
//    implementation Libs.ThirdLib.jgit
    implementation(Dep.Glide.glide)
    implementation(Dep.Glide.glideProcessor)
//    implementation(Dep.ThirdLib.conscrypt)

//    implementation(Dep.Acra.acraMail)
//    implementation(Dep.Acra.acraDialog)

    //dagger依赖注入
//    api Libs.Dagger2.dagger2
//    kapt Libs.Dagger2.dagger2Compiler
//    kapt Libs.Dagger2.dagger2AnnotationProcessor

//    api Libs.Dagger2.hiltAndroid
//    kapt Libs.Dagger2.hiltCompiler

//    debugImplementation(Dep.Stetho.stetho)
//    debugImplementation(Dep.Stetho.stethoTimber)
//    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
//    testImplementation 'junit:junit:4.+'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
}