buildscript {
    dependencies {
        classpath(libs.oss.licenses.plugin)
    }
}
    version = "1.0.5"
plugins {
    alias(libs.plugins.kotlin.android) apply (false)
    alias(libs.plugins.android.library) apply (false)
    alias(libs.plugins.android.application) apply (false)
    alias(libs.plugins.kotlin.serialization) apply (false)
    alias(libs.plugins.dagger.hilt.android) apply (false)
    alias(libs.plugins.firebase.crashlytics) apply (false)
    alias(libs.plugins.firebase.perf) apply false
    alias(libs.plugins.kotlin.compose.compiler) apply (false)
    alias(libs.plugins.ksp) apply (false)
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.gms) apply (false)
    id("java")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    project(":app")

    project(":core")
    project(":core:common")
    project(":core:database")
    project(":core:model")
    project(":core:network")
    project(":core:utils")

    project(":di")
    project(":di:database")
    project(":di:network")
    project(":di:presentation")
    project(":di:repository")
    project(":di:usecase")

    project(":domain")
    project(":domain:interactor")
    project(":domain:repository")
    project(":domain:usecase")

    project(":presentation")
    project(":presentation:basefeature")
    project(":presentation:moviesfeature")

    project(":testing")
    project(":testing:fake")
    project(":testing:helper")
    project(":testing:mock")
    project(":testing:rules")
}