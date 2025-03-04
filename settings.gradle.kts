import java.net.URI

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}

buildCache {
    local {
        isEnabled = true
    }
    remote(HttpBuildCache::class.java) {
        url = URI("https://cache.example.com/")
        isPush = true
    }
}

rootProject.name = "ArchitecturalProject"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(":core")
include(":core:common")
include(":core:database")
include(":core:model")
include(":core:network")
include(":core:utils")
include(":di")
include(":di:database")
include(":di:network")
include(":di:presentation")
include(":di:repository")
include(":di:usecase")
include(":domain")
include(":domain:interactor")
include(":domain:repository")
include(":domain:usecase")
include(":testing")
include(":testing:fake")
include(":testing:helper")
include(":testing:mock")
include(":testing:rules")
include(":presentation")
include(":presentation:basefeature")
include(":presentation:settingsfeature")
include(":core:ui")
