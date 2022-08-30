package com.nridwan.compose.ui.placeholder

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun PlaceholderScreen(navController: NavController) {
    val activity = (LocalContext.current as? Activity)
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = {
                if(navController.previousBackStackEntry == null)
                    activity?.finish()
                else
                    navController.popBackStack()
            }) {
                Text("Back")
            }
        }
    }
}