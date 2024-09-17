package com.example.calculadoraresistencias.src.utils
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.material3.IconButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSample() {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Calculadora Resistencia") },
        actions = {

        })
    Spacer(modifier = Modifier.height(32.dp))

}