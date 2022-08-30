package com.nridwan.compose.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.nridwan.compose.home.home.HomeScreen
import com.nridwan.compose.home.profile.ProfileScreen
import com.nridwan.compose.ui.nav.SharedNav

sealed class HomeNavigation(val route: String) {
    object Home: HomeNavigation("${SharedNav.HOME}.home")
    object Profile: HomeNavigation("${SharedNav.HOME}.profile")
}

fun NavGraphBuilder.homeGraph(navController: NavController){
    navigation(
        startDestination = HomeNavigation.Home.route,
        route = SharedNav.HOME
    ){
        composable(HomeNavigation.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(HomeNavigation.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}