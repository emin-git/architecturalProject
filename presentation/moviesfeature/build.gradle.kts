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
    namespace = "com.emin.presentation.moviesfeature"
    packagingOptions {
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {
    project.let {
        compose(it)
        hilt(it)
    }
    moduleCore()
    moduleDomain()
    modulePresentationBaseFeature()
}