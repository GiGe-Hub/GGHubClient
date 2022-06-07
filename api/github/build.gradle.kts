import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.sophimp.plugin.Dep
import com.sophimp.plugin.Dep.SdkVersion

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
//    id("com.apollographql.apollo3").version("3.1.0")
//    id("org.jetbrains.kotlin.kapt")
}

android {
    compileSdk = SdkVersion.compileSdkVersion

//    buildFeatures {
//        compose = true
//    }

    defaultConfig {
        minSdk = SdkVersion.minSdkVersion
        targetSdk = SdkVersion.targetSdkVersion


        val properties = gradleLocalProperties(rootDir)
        buildConfigField("String", "CLIENT_ID", properties.getProperty("CLIENT_ID"))
        buildConfigField("String", "CLIENT_SECRET", properties.getProperty("CLIENT_SECRET"))
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

//    composeOptions {
//        kotlinCompilerExtensionVersion = Dep.AndroidX.Compose.version
//    }

//    apollo {
//        packageName.set("com.gghub.api")
//
//        // Alternatively, if you're migrating from 2.x, you can keep the 2.x
//        // behaviour with `packageNamesFromFilePaths()`:
////    packageNamesFromFilePaths()
//    }
}


dependencies {
    implementation(Dep.AndroidX.annotation)
    implementation(Dep.AndroidX.CommonLib.appCompat)
    implementation(Dep.AndroidX.coreKtx)

    implementation(Dep.Square.retrofit)
    implementation(Dep.Square.retrofitConverterGson)

//    implementation(Dep.Apollo.apolloRuntime)
//    implementation(Dep.Apollo.apolloApi)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}