@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.plugin.ui.library)
    alias(libs.plugins.plugin.hilt)
}

android {
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
    namespace = "com.emin.presentation.settingsfeature"
    packagingOptions {
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {
    implementation(project(":domain:repository"))
    implementation(project(":core:network"))
    project.let {
        compose(it)
        hilt(it)
    }
    moduleCoreCommon()
    moduleCoreModel()
    moduleDomainUseCase()
    moduleDomainRepository()
    modulePresentationBaseFeature()
}