pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android_Solid_Principles"
include(":app")
include(":feature-srp-user")
include(":feature-ocp-payment")
include(":feature-lsp-auth")
include(":feature-isp-feed")
include(":feature-dip-notification")
