import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compnetscontrols.MiConstraintLayout
import com.example.compnetscontrols.MiLazyColumn
import com.example.compnetscontrols.MiLazyRow
import com.example.compnetscontrols.MiLazyVerticalGrid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Mi Scaffold") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Acción del botón flotante */ }) {
                Text(text = "+")
            }
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text(text = "Contenido del Scaffold", modifier = Modifier.padding(16.dp))

                MiLazyColumn()
                Spacer(modifier = Modifier.height(16.dp))
                MiLazyRow()
                Spacer(modifier = Modifier.height(16.dp))
                MiLazyVerticalGrid()
                Spacer(modifier = Modifier.height(16.dp))
                MiConstraintLayout()
                Spacer(modifier = Modifier.height(16.dp))

                // Agregando el nuevo componente Switch personalizado
                InterruptorPersonalizado(titulo = "Activar opción")
            }
        }
    )
}

@Composable
fun InterruptorPersonalizado(titulo: String) {
    val estado = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = titulo)
        Switch(
            checked = estado.value,
            onCheckedChange = { estado.value = it }
        )
    }
}
