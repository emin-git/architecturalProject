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
    namespace = "com.emin.core.network"
}

dependencies {
    moduleCoreCommon()
    moduleCoreModel()
    moduleDomainRepository()
    moduleCoreUtils()
    project.let {
        retrofit(it)
        http(it)
    }
    implementation(platform(libs.okhttp.bom))
}