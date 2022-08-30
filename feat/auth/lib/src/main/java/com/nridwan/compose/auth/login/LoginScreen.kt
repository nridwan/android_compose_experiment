package com.nridwan.compose.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nridwan.compose.ui.nav.SharedNav

@Composable
fun LoginScreen(navController: NavController) {
    LoginView {
        navController.navigate(SharedNav.HOME) {
            popUpTo(SharedNav.ROOT) {
                inclusive = true
            }
        }
    }
}

@Composable
fun LoginView(onLogin: () -> Unit) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val username = remember { mutableStateOf(TextFieldValue("")) }
            val password = remember { mutableStateOf(TextFieldValue("")) }
            Text("Login")
            TextField(
                value = username.value,
                onValueChange = {username.value = it},
                label = { Text("username") }
            )
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                value = password.value,
                onValueChange = {password.value = it},
                label = { Text("password") }
            )
            Button(onClick = onLogin) {
                Text("Login")
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    LoginView {}
}