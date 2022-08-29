package com.nridwan.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.nridwan.compose.ui.theme.ComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                val navController = rememberNavController()

            }
        }
    }
}

@Composable
fun Greeting(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun PreviewGreeting() {
    Greeting(text = "Hello World")
}