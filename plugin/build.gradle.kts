import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins {
    `java-gradle-plugin`
    idea
    kotlin("jvm") version "1.6.10"
    `kotlin-dsl`
}

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

group = "com.sophimp.plugin"
version = "0.0.1"


gradlePlugin {
    plugins {
        create("sophimp-dep"){
            id = "sophimp-dep"
            implementationClass = "com.sophimp.plugin.SSDepPlugin"
        }

        create("sophimp-publish"){
            id = "sophimp-publish"
            implementationClass = "com.sophimp.plugin.SSPublish"
        }
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    api(gradleApi())
    api(gradleKotlinDsl())
    api(kotlin("gradle-plugin", version = "1.6.10"))
    api(kotlin("gradle-plugin-api", version = "1.6.10"))
    api("com.android.tools.build:gradle-api:7.1.2")
    api("com.android.tools.build:gradle:7.1.2")
//    implementation(kotlin("stdlib-jdk8"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "11"
}