package com.nridwan.compose.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.nridwan.compose.auth.login.LoginScreen
import com.nridwan.compose.ui.nav.SharedNav

sealed class AuthNavigation(val route: String) {
    object Login: AuthNavigation("${SharedNav.AUTH}.login")
}

fun NavGraphBuilder.authGraph(navController: NavController){
    navigation(
        startDestination = AuthNavigation.Login.route,
        route = SharedNav.AUTH
    ){
        composable(AuthNavigation.Login.route) {
            LoginScreen(navController)
        }
    }
}