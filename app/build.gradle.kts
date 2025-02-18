@file:Suppress("UnstableApiUsage")

import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import java.io.FileInputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Properties

val keystorePropertiesFile: File = rootProject.file("keystore.properties")

plugins {
    alias(libs.plugins.plugin.application)
    alias(libs.plugins.plugin.hilt)
    alias(libs.plugins.plugin.firebase)
}

android {
    val majorUpdateVersion = 1
    val minorUpdateVersion = 0
    val patchVersion = 0

    val mVersionCode = majorUpdateVersion.times(10_000)
        .plus(minorUpdateVersion.times(100))
        .plus(patchVersion)

    val mVersionName = "$majorUpdateVersion.$minorUpdateVersion.$patchVersion"
    val formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_hh_mm_a")
    val currentTime = LocalDateTime.now().format(formatter)

    defaultConfig {
        versionCode = mVersionCode
        versionName = mVersionName
        applicationId = "dev.emin.compose"
    }

    signingConfigs {
        create("release") {
            if (keystorePropertiesFile.exists()) {
                val keystoreProperties = Properties()
                keystoreProperties.load(FileInputStream(keystorePropertiesFile))
                keyAlias = keystoreProperties["keyAlias"] as String
                keyPassword = keystoreProperties["keyPassword"] as String
                storeFile = file(keystoreProperties["storeFile"] as String)
                storePassword = keystoreProperties["storePassword"] as String
            }
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = true
            applicationVariants.all {
                outputs.all {
                    (this as BaseVariantOutputImpl).outputFileName =
                        rootProject.name.replace(" ", "_") + "_" +
                                (buildType.name + "_v") +
                                (versionName + "_") +
                                "${currentTime}.apk"
                    println(outputFileName)
                }
            }
            signingConfig = if (keystorePropertiesFile.exists()) {
                signingConfigs.getByName("release")
            } else {
                signingConfigs.getByName("debug")

            }
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }

    namespace = "dev.emin.compose"
}

dependencies {
}