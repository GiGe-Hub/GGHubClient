import com.sophimp.plugin.Dep

//import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
//    signingConfigs {
//        val properties = Properties()
//        val propFile = project.file("release.properties")
//        if (propFile.exists()) {
//            properties.load(propFile.inputStream())
//        }
//        create("release"){
//            keyAlias = properties.getProperty("RELEASE_KEY_ALIAS")
//            keyPassword = properties.getProperty("RELEASE_KEY_PASSWORD")
//            storeFile = file("qmuidemo.keystore")
//            storePassword = properties.getProperty("RELEASE_STORE_PASSWORD")
//            enableV2Signing = true
//        }
//    }

    compileSdk = Dep.SdkVersion.compileSdkVersion
    compileOptions {
        sourceCompatibility = Dep.SdkVersion.javaVersion
        targetCompatibility = Dep.SdkVersion.javaVersion
    }

    kotlinOptions {
        jvmTarget = Dep.SdkVersion.kotlinJvmTarget
        freeCompilerArgs += "-Xjvm-default=all"
    }

    buildFeatures {
        compose = false
        // Disable unused AGP features
        buildConfig = true
        viewBinding = true
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dep.AndroidX.Compose.version
    }

    defaultConfig {
        applicationId = "com.sophimp.gghub"
        minSdk = Dep.SdkVersion.minSdkVersion
        targetSdk = Dep.SdkVersion.targetSdkVersion
//        versionCode = gitVersion
        versionCode = Dep.SdkVersion.versionCode
        versionName = Dep.DepPlug.depPlugVer

        ndk {
            abiFilters.add("arm64-v8a")
        }
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
}

dependencies {
    implementation(Dep.AndroidX.CommonLib.appCompat)
    implementation(Dep.AndroidX.annotation)
    implementation(Dep.Themes.material)

    implementation(Dep.Kotlin.stdlib)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.Themes.material)
    implementation(Dep.AndroidX.CommonLib.constraintLayout)
    implementation(Dep.TabLayout.tabLayout)
    implementation(Dep.TabLayout.dslAdapter)

    implementation(Dep.Timber.timber)

    implementation(project(":libs:base"))
    implementation(project(":component:eeditor"))
//    implementation project(":libs:widget")
//    implementation project(":libs:github")
//    implementation project(":component:md-editor")
//    implementation project(":component:explore")
//    implementation project(":component:github")
//    implementation project(":component:mine")
//    implementation project(":openhub")

    implementation(Dep.Dagger2.hiltAndroid)
    kapt(Dep.Dagger2.hiltCompiler)

//    testImplementation 'junit:junit:4.+'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
}