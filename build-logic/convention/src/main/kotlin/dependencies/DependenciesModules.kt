import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.moduleCoreCommon() = implementation(project(Modules.Core.common))
fun DependencyHandler.moduleCoreDatabase() = implementation(project(Modules.Core.database))
fun DependencyHandler.moduleCoreModel() = implementation(project(Modules.Core.model))
fun DependencyHandler.moduleCoreNetwork() = implementation(project(Modules.Core.network))
fun DependencyHandler.moduleCoreUtils() = implementation(project(Modules.Core.utils))
fun DependencyHandler.moduleDiDatabase() = implementation(project(Modules.di.database))
fun DependencyHandler.moduleDiNetwork() = implementation(project(Modules.di.network))
fun DependencyHandler.moduleDiPresentation() = implementation(project(Modules.di.presentation))
fun DependencyHandler.moduleDiRepository() = implementation(project(Modules.di.repository))
fun DependencyHandler.moduleDiUseCase() = implementation(project(Modules.di.usecase))
fun DependencyHandler.moduleDomainInteractor() = implementation(project(Modules.domain.interactor))
fun DependencyHandler.moduleDomainRepository() = implementation(project(Modules.domain.repository))
fun DependencyHandler.moduleDomainUseCase() = implementation(project(Modules.domain.usecase))
fun DependencyHandler.moduleTestingFake() = implementation(project(Modules.testing.fake))
fun DependencyHandler.moduleTestingHelper() = implementation(project(Modules.testing.helper))
fun DependencyHandler.moduleTestingMock() = implementation(project(Modules.testing.mock))
fun DependencyHandler.moduleTestingRules() = implementation(project(Modules.testing.rules))
fun DependencyHandler.modulePresentationBaseFeature() = implementation(project(Modules.presentation.baseFeature))
fun DependencyHandler.modulePresentationSettingsFeature() = implementation(project(Modules.presentation.settings))


fun DependencyHandler.moduleCore() {
    moduleCoreModel()
    moduleCoreUtils()
    moduleCoreNetwork()
    moduleCoreCommon()
    moduleCoreDatabase()
}

fun DependencyHandler.moduleDi(){
    moduleDiPresentation()
    moduleDiRepository()
    moduleDiUseCase()
    moduleDiNetwork()
    moduleDiDatabase()
}

fun DependencyHandler.moduleDomain(){
    moduleDomainInteractor()
    moduleDomainRepository()
    moduleDomainUseCase()
}

fun DependencyHandler.moduleTesting(){
    moduleTestingFake()
    moduleTestingMock()
    moduleTestingHelper()
    moduleTestingRules()
}