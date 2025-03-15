@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.plugin.ui.library)
}

android {
    namespace = "com.emin.core.ui"
}

dependencies {
    moduleCoreCommon()
    api(libs.androidx.appcompat)
    api(libs.androidx.fragment.ktx)
    project.let {
        activity(it)
        lifecycle(it)
        navigation(it)
        coil(it)
    }
    api(libs.lottie)
}