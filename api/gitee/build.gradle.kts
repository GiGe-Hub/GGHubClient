import com.sophimp.plugin.Dep.SdkVersion
import com.sophimp.plugin.Dep
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = SdkVersion.compileSdkVersion

    defaultConfig {
        minSdk = SdkVersion.minSdkVersion
        targetSdk = SdkVersion.targetSdkVersion
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = SdkVersion.javaVersion
        targetCompatibility = SdkVersion.javaVersion
    }
    kotlinOptions {
        jvmTarget = SdkVersion.kotlinJvmTarget
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dep.AndroidX.Compose.version
    }
}

dependencies {
    implementation(Dep.AndroidX.annotation)
    implementation(Dep.AndroidX.CommonLib.appCompat)
    implementation(Dep.AndroidX.coreKtx)

    implementation(Dep.Square.okhttp)
    implementation(Dep.Square.okio)
    implementation(Dep.Square.retrofit)
    implementation(Dep.Square.retrofitConverterGson)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}