package com.emin.architecturalproject.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.emin.moviesfeature.navigation.MoviesNavGraph
import com.emin.moviesfeature.navigation.moviesNavGraph
import com.emin.moviesfeature.navigation.moviesScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NavHost() {
    val navController = rememberNavController()
    val startDestination = MoviesNavGraph::class

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            Log.d("NavigationLogger", "Navigating to: ${destination.route}")
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        moviesNavGraph (
            nestedNavGraphs = {
                moviesScreen()
            }
        )
    }
}