package com.example.compnetscontrols

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BotonPersonalizado(onClick: () -> Unit, texto: String) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.primary),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(text = texto, color = Color.White)
    }
}
