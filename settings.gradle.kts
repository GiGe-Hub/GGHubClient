
pluginManagement {
    repositories {
        maven(url = "https://mvnrepository.com")
        maven(url = "https://maven.aliyun.com/repository/public")
        maven(url = "https://maven.aliyun.com/repository/jcenter")
        maven(url = "https://maven.aliyun.com/repository/google")
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://jitpack.io")
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven(url = "https://mvnrepository.com")
        maven(url = "https://maven.aliyun.com/repository/public")
        maven(url = "https://maven.aliyun.com/repository/jcenter")
        maven(url = "https://maven.aliyun.com/repository/google")
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://jitpack.io")
        google()
        mavenCentral()
    }
}

includeBuild("./plugin")

//include(":app-compose")
include(":app-view")
//include(":qmui")
//include(":lib")
//include(":compiler")
//include(":arch")
//include(":arch-compiler")
//include(":arch-annotation")
//include(":type")
//include(":compose-core")
//include(":compose")
//include(":photo")
//include(":photo-coil")
include(":libs:base")
include(":api:github")
include(":api:gitee")
include(":component:eeditor")
include(":component:mine")
