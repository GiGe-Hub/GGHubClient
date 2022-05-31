import com.sophimp.plugin.Dep
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

//fun runCommand(project: Project, command: String): String {
//    val stdout = ByteArrayOutputStream()
//    project.exec {
//        commandLine = command.split(" ")
//        standardOutput = stdout
//    }
//    return stdout.toString().trim()
//}


//val gitVersion = runCommand(project, "git rev-list HEAD --count").toIntOrNull() ?: 1


android {
    signingConfigs {
        val properties = Properties()
        val propFile = project.file("release.properties")
        if (propFile.exists()) {
            properties.load(propFile.inputStream())
        }
        create("release"){
            keyAlias = properties.getProperty("RELEASE_KEY_ALIAS")
            keyPassword = properties.getProperty("RELEASE_KEY_PASSWORD")
            storeFile = file("qmuidemo.keystore")
            storePassword = properties.getProperty("RELEASE_STORE_PASSWORD")
            enableV2Signing = true
        }
    }

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
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dep.AndroidX.Compose.version
    }

    defaultConfig {
        applicationId = "com.gghub.app"
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
    }
}

dependencies {
    implementation(Dep.AndroidX.CommonLib.appCompat)
    implementation(Dep.AndroidX.annotation)
    implementation(Dep.Themes.material)
    implementation(Dep.AndroidX.Compose.constraintLayout)
    implementation(Dep.AndroidX.Compose.pager)
//    implementation(project(":lib"))
    implementation(Dep.Flipper.soLoader)
    implementation(Dep.Flipper.flipper)
    api(Dep.AndroidX.annotation)
    api(Dep.AndroidX.CommonLib.appCompat)
    api(Dep.AndroidX.coreKtx)
    api(Dep.AndroidX.Compose.ui)
    api(Dep.AndroidX.Compose.activity)
    api(Dep.AndroidX.Compose.tooling)
    api(Dep.AndroidX.Compose.animation)
    api(Dep.AndroidX.Compose.material)
    api(Dep.AndroidX.Compose.compiler)
    api(Dep.AndroidX.Compose.constraintLayout)
    testImplementation("junit:junit:4.12")
//    kapt(project(":compiler"))
//    kapt(project(":arch-compiler"))

//    implementation("com.iqiyi.xcrash:xcrash-android-lib:3.1.0")
}
