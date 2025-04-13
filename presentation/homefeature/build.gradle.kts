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
        minSdk = defaultConfig.minSdk
    }
    namespace = "com.emin.presentation.homefeature"
    packagingOptions {
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }
    buildTypes {
        debug {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":presentation:moviesfeature"))
    project.let {
        compose(it)
        hilt(it)
        apps(it)
    }
    moduleCore()
    moduleDomain()
    modulePresentationBaseFeature()
    implementation("com.github.emin-git:SuperMusic:v1.0.2")

}