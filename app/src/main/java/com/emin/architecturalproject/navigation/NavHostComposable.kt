package com.emin.architecturalproject.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.emin.homefeature.navigation.HomeNavGraph
import com.emin.homefeature.navigation.homeNavGraph
import com.emin.homefeature.navigation.homeScreen
import com.emin.moviesfeature.navigation.moviesScreen
import com.google.firebase.crashlytics.FirebaseCrashlytics

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NavHostComposable() {
    val navController = rememberNavController()
    val startDestination = HomeNavGraph::class
    //val startDestination = MoviesNavGraph::class

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            Log.d("NavigationLogger", "Navigating to: ${destination.route}")
            FirebaseCrashlytics.getInstance().log("Navigating to: $destination.route")
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        homeNavGraph(
            nestedNavGraphs = {
                homeScreen(navController)
            }
        )
        moviesScreen()
    }
}