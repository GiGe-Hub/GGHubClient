
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

includeBuild("./plugin")

include(":app")
//include(":qmui")
//include(":lib")
//include(":compiler")
//include(":arch")
//include(":arch-compiler")
//include(":arch-annotation")
//include(":type")
include(":compose-core")
include(":compose")
include(":photo")
include(":photo-coil")
include(":api:github")
include(":api:gitee")
