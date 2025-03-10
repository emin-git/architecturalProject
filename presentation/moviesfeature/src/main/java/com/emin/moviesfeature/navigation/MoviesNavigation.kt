package com.emin.moviesfeature.navigation

import MoviesScreen
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
data object Movies

@Serializable
data object MoviesNavGraph

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
fun NavGraphBuilder.moviesScreen(){
    composable<Movies>{
        MoviesScreen()
    }
}

fun NavGraphBuilder.moviesNavGraph(
    nestedNavGraphs: NavGraphBuilder.() -> Unit
){
    navigation<MoviesNavGraph>(startDestination = Movies) {
        nestedNavGraphs()
    }
}