package com.nridwan.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nridwan.compose.auth.authGraph
import com.nridwan.compose.home.homeGraph
import com.nridwan.compose.splash.SplashScreen
import com.nridwan.compose.ui.nav.SharedNav

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        route = SharedNav.ROOT,
        navController = navController,
        startDestination = SharedNav.SPLASH
    ) {
        composable(SharedNav.SPLASH) {
            SplashScreen(navController = navController)
        }
        authGraph(navController)
        homeGraph(navController)
    }
}