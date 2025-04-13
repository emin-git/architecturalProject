package com.emin.homefeature.navigation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.emin.homefeature.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object Home

@Serializable
data object HomeNavGraph

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
fun NavGraphBuilder.homeScreen(navController: NavHostController){
    composable<Home>{
        HomeScreen(navController)
    }
}


fun NavGraphBuilder.homeNavGraph(
    nestedNavGraphs: NavGraphBuilder.() -> Unit
){
    navigation<HomeNavGraph>(startDestination = Home) {
        nestedNavGraphs()
    }
}