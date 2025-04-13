object Modules {

    const val app = ":app"

    object Core {
        const val common = ":core:common"
        const val database = ":core:database"
        const val model = ":core:model"
        const val network = ":core:network"
        const val utils = ":core:utils"
        const val ui = ":core:ui"
    }

    object di{
        const val database = ":di:database"
        const val network = ":di:network"
        const val presentation = ":di:presentation"
        const val repository = ":di:repository"
        const val usecase = ":di:usecase"
    }

    object domain{
        const val interactor = ":domain:interactor"
        const val repository = ":domain:repository"
        const val usecase = ":domain:usecase"
    }

    object presentation{
        const val baseFeature = ":presentation:basefeature"
        const val movies = ":presentation:moviesfeature"
        const val home = ":presentation:homefeature"
    }

    object Feature {
        const val baseFeature = ":feature:baseFeature"
    }

    object testing{
        const val fake = ":testing:fake"
        const val helper = ":testing:helper"
        const val mock = ":testing:mock"
        const val rules = ":testing:rules"
    }
}