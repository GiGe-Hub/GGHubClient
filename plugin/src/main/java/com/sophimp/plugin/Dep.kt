package com.sophimp.plugin

import org.gradle.api.JavaVersion

object Dep {

    object Versions {
        const val ktlint = "0.41.0"
    }

    object SdkVersion {
        const val compileSdkVersion = 31
        const val buildToolsVersion = "31.0.0"
        const val minSdkVersion = 21
        const val targetSdkVersion = 31
        const val versionCode = 1
        const val versionName = "1.0"
        val javaVersion = JavaVersion.VERSION_11
        const val kotlinJvmTarget = "11"

        const val androidGradlePlugin = "com.android.tools.build:gradle:7.1.2"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"
    }

    object DepPlug {
        const val group = "com.sophimp"
        const val depPlugVer = "0.0.1"
        const val composeCoreVer = "0.0.1"
        const val composeVer = "0.0.1"
    }

    object Themes {
        const val material = "com.google.android.material:material:1.4.0"
    }

    object Accompanist {
        const val version = "0.18.0"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
    }

    object Kotlin {
        const val version = "1.6.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Coroutines {
        private const val version = "1.6.0"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object JUnit {
        private const val version = "4.13"
        const val junit = "junit:junit:$version"
    }

    object ThirdLib {
        const val circleImageView = "de.hdodenhof:circleimageview:3.1.0"
        const val searchView = "com.github.iammert:MultiSearchView:0.3"
        const val jsch = "com.jcraft:jsch:0.1.55"

        const val commonIO = "commons-io:commons-io:2.11.0"

        const val jgit = "org.eclipse.jgit:org.eclipse.jgit:6.0.0.202111291000-r"

        const val mmkv = "com.tencent:mmkv:1.2.11"

        const val conscrypt = "org.conscrypt:conscrypt-android:1.1.0"

        const val autoAccess = "com.neenbedankt.gradle.plugins:android-apt:1.8"
    }

    object Square {
        const val okhttp = "com.squareup.okhttp3:okhttp:4.9.1"
        const val okio = "com.squareup.okio:okio:3.0.0"

        private const val retrofitVersion = "2.1.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val retrofitAdapterRxjava = "com.squareup.retrofit2:adapter-rxjava:$retrofitVersion"
        const val retrofitConverterSimpleXml = "com.squareup.retrofit2:converter-simplexml:$retrofitVersion"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val preference = "androidx.preference:preference:1.1.1"
        const val browser = "androidx.browser:browser:1.3.0"
        const val annotation = "androidx.annotation:annotation:1.3.0"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
        const val multiDex = "androidx.multidex:multidex:2.0.1"

        object VectorDrawable {
            const val version = "1.1.0"
            const val vectorDrawable = "androidx.vectordrawable:vectordrawable:$version"

            /* To be able to animate properties of a VectorDrawable, add the following.  Useful for
             * illustration purposes or state changes in response to user events
             */
            const val vectorDrawableAnimation =
                "androidx.vectordrawable:vectordrawable-animated:$version"

            /* To use a seekable alternative for `androidx.vectordrawable:vectordrawable-animated` add the
             * following
             */
            const val vectorDrawableSeekable =
                "androidx.vectordrawable:vectordrawable-seekable:1.0.0-alpha02"
        }

        object CommonLib {
            private const val appcompat_version = "1.4.0"
            const val appCompat = "androidx.appcompat:appcompat:$appcompat_version"
            const val fragment = "androidx.fragment:fragment:${appcompat_version}"
            const val activity = "androidx.activity:activity-ktx:${appcompat_version}"
            const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
            const val recyclerViewSelection =
                "androidx.recyclerview:recyclerview-selection:1.1.0"
            const val cardView = "androidx.cardview:cardview:1.0.0"
            const val vectorDrawable = "androidx.vectordrawable:vectordrawable:1.1.0"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.2"
        }

        object Jetpack {
            const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
            const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:2.4.0"

        }

        object Compose {
            const val snapshot = ""
            const val version = "1.1.1"
            const val extensionVersion = "1.1.0-alpha05"

            const val compiler = "androidx.compose.compiler:compiler:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val iconsExtended =
                "androidx.compose.material:material-icons-extended:$version"
            const val iconsCore = "androidx.compose.material:material-icons-core:$version"
            const val material = "androidx.compose.material:material:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:$version"
            const val uiUnit = "androidx.compose.ui:ui-unit:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"
            const val activity = "androidx.activity:activity-compose:1.4.0"
            const val constraintLayout =
                "androidx.constraintlayout:constraintlayout-compose:1.0.0"
            const val pager = "com.google.accompanist:accompanist-pager:0.24.0-alpha"
        }

        object Test {
            private const val version = "1.4.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    object Stetho {
        private const val version = "1.5.0"
        const val stetho = "com.facebook.stetho:stetho:$version"
        const val stethoTimber = "com.facebook.stetho:stetho-timber:$version"
    }

    object Glide {
        private const val version = "4.12.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val glideProcessor = "com.github.bumptech.glide:compiler:$version"
    }

    object Timber {
        const val timber = "com.jakewharton.timber:timber:5.0.1"
    }

    object Acra {
        private const val acraVersion = "5.8.4"
        const val acraMail = "ch.acra:acra-mail:$acraVersion"
        const val acraDialog = "ch.acra:acra-dialog:$acraVersion"
    }

    object TabLayout {
        const val dslAdapter = "com.github.angcyo:DslAdapter:3.0.2"
        const val tabLayout = "com.github.angcyo.DslTablayout:TabLayout:3.0.3"
    }

    object RxHttp {
        private const val version = "2.8.3"
        const val rxhttp = "com.github.liujingxing.rxhttp:rxhttp:$version"
        const val rxhttpCompiler = "com.github.liujingxing.rxhttp:rxhttp-compiler:$version"
    }

    object Dagger2 {
        private const val version = "2.40.5"
        const val dagger2 = "com.google.dagger:dagger:$version"
        const val dagger2Compiler = "com.google.dagger:dagger-compiler:$version"
        const val dagger2AnnotationProcessor =
            "com.google.dagger:dagger-android-processor:$version"
        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$version"
        const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:$version"

        // For instrumentation tests
//        androidTestImplementation  'com.google.dagger:hilt-android-testing:2.40.5'
//        kaptAndroidTest  'com.google.dagger:hilt-compiler:2.40.5'
        // For local unit tests
//        testImplementation 'com.google.dagger:hilt-android-testing:2.40.5'
//        kaptTest  'com.google.dagger:hilt-compiler:2.40.5'
    }

    object Flipper {
        private const val version = "0.96.1"
        const val soLoader = "com.facebook.soloader:soloader:0.10.1"
        const val flipper = "com.facebook.flipper:flipper:$version"
    }

    object CodeGen {
        const val javapoet = "com.squareup:javapoet:1.13.0"
        const val autoService = "com.google.auto.service:auto-service:1.0-rc2"
    }

    object Coil {
        const val compose = "io.coil-kt:coil-compose:2.0.0-alpha06"
    }

    object Apollo {
        private const val version = "3.1.0"
        const val apolloRuntime = "com.apollographql.apollo3:apollo-runtime:$version"
        const val apolloCacheSqlite = "com.apollographql.apollo3:apollo-normalized-cache-sqlite:$version"
        const val apolloApi = "com.apollographql.apollo3:apollo-api:$version"

    }
}
