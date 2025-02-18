import org.gradle.kotlin.dsl.compileOnly
import org.gradle.kotlin.dsl.gradlePlugin
import org.gradle.kotlin.dsl.libs
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "dev.emin.build.logic"

val javaVersion = libs.versions.java.get().toInt()

java {
    sourceCompatibility = JavaVersion.values()[javaVersion - 1]
    targetCompatibility = JavaVersion.values()[javaVersion - 1]
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.valueOf("JVM_$javaVersion"))
    }
}

dependencies {
    compileOnly(libs.gradlePlugin.kotlin)
    compileOnly(libs.gradlePlugin.android)
    compileOnly(libs.gradlePlugin.compose)
}

gradlePlugin {
    plugins {
        register("application") {
            id = "dev.emin.application"
            implementationClass = "ApplicationPlugin"
        }
        register("firebase") {
            id = "dev.emin.firebase"
            implementationClass = "FirebasePlugin"
        }
        register("hilt") {
            id = "dev.emin.hilt"
            implementationClass = "HiltPlugin"
        }
        register("library") {
            id = "dev.emin.library"
            implementationClass = "LibraryPlugin"
        }
        register("uiLibrary") {
            id = "dev.emin.ui.library"
            implementationClass = "UiLibraryPlugin"
        }
    }
}