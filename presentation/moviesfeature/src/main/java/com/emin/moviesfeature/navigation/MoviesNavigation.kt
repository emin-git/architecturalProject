package com.emin.moviesfeature.navigation

import MoviesScreen
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
data object Movies

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
fun NavController.navigateMoviesScreen(){
    navigate(Movies)
}


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
fun NavGraphBuilder.moviesScreen(){
    composable<Movies>{
        MoviesScreen()
    }
}