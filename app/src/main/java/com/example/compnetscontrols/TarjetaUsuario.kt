package com.example.compnetscontrols

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TarjetaUsuario(nombre: String, correo: String) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface, // Define el color de fondo
        shadowElevation = 4.dp // Agrega sombra sin usar 'elevation' de Card
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = nombre, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = correo, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
