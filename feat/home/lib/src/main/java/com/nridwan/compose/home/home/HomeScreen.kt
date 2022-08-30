package com.nridwan.compose.home.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.nridwan.compose.home.HomeNavigation
import com.nridwan.compose.ui.nav.SharedNav

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = {
                navController.navigate(HomeNavigation.Profile.route)
            }) {
                Text("Profile")
            }
            Button(onClick = {
                navController.navigate(SharedNav.AUTH) {
                    popUpTo(SharedNav.ROOT) {
                        inclusive = true
                    }
                }
            }) {
                Text("Logout")
            }
        }
    }
}