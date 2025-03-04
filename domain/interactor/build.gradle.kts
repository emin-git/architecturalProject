@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.plugin.library)
    alias(libs.plugins.plugin.hilt)
}

android {
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
    namespace = "com.emin.domain.interactor"
}

dependencies {
    moduleCoreCommon()
    moduleDomainRepository()
    moduleDomainUseCase()
}