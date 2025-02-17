import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class FirebasePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            val firebaseBom = libs.findLibrary("firebase-bom").get()
            val analytics = libs.findLibrary("firebase.analytics").get().toString()
            val crashlytics = libs.findLibrary("firebase.crashlytics").get().toString()
            val pref = libs.findLibrary("firebase.perf").get().toString()

            with(pluginManager) {
                apply("com.google.gms.google-services")
                apply("com.google.firebase.crashlytics")
            }

            dependencies {
                add("implementation", platform(firebaseBom))
                "implementation"(libs.findLibrary(analytics).get())
                "implementation"(libs.findLibrary(crashlytics).get())
                "implementation"(libs.findLibrary(pref).get())
            }
        }
    }
}