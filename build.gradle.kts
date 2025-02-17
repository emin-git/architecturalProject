plugins {
    alias(libs.plugins.kotlin.android) apply (false)
    alias(libs.plugins.android.library) apply (false)
    alias(libs.plugins.android.application) apply (false)
    alias(libs.plugins.kotlin.serialization) apply (false)
    alias(libs.plugins.dagger.hilt.android) apply (false)
    alias(libs.plugins.firebase.crashlytics) apply (false)
    alias(libs.plugins.firebase.perf) apply false
    alias(libs.plugins.kotlin.compose.compiler) apply (false)
    alias(libs.plugins.secrets) apply (false)
    alias(libs.plugins.ksp) apply (false)
}

dependencies {
    project(":app")
}