package com.example.compnetscontrols

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.TooltipArea

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compnetscontrols.ui.theme.CompnetsControlsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompnetsControlsTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MiScaffold()
                }
            }
        }
    }
}

@Composable
fun MiLazyColumn() {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(10) { index ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .background(
                        MaterialTheme.colorScheme.surface,
                        shape = MaterialTheme.shapes.medium)
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.onSurface,
                        shape = MaterialTheme.shapes.medium)
                    .padding(16.dp)) {
                Text(
                    text = "Elemento $index",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Composable
fun MiLazyRow() {
    LazyRow(modifier = Modifier.padding(16.dp)) {
        items(10) { index ->
            Text(text = "Elemento $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun MiLazyVerticalGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(10) { index ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Elemento $index",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}


@Composable
fun MiConstraintLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (text1, text2, text3) = createRefs()
        Text(
            text = "Texto 1",
            modifier = Modifier
                .constrainAs(text1) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp) }
                .padding(8.dp))
        Text(text = "Texto 2",
            modifier = Modifier
                .constrainAs(text2) {
                    top.linkTo(text1.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp) }
                .padding(8.dp))
        Text(text = "Texto 3",
            modifier = Modifier
                .constrainAs(text3) {
                    top.linkTo(text2.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp) }
                .padding(8.dp)
        )
    }
}

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
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    CompnetsControlsTheme {
        MiScaffold()
    }
}

@Composable
fun ViewHolaCurso() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Vienvendo al curso!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Hola!",
            fontSize = 20.sp
        )
    }
}
// Ejemplo de AlertDialog
@Preview
@Composable
fun SimpleAlertDialog() {
    var showDialog by remember { mutableStateOf(false) }
    Button(onClick = { showDialog = true }) {
        Text("Ejemplo de un dialogo......Jimmy")
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("") },
            text = { Text("") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Ok")
                }
            }
        )
    }
}


// Ejemplo de Checkbox
@Preview
@Composable
fun Checkbox() {
    var checked by remember { mutableStateOf(false) }
    Checkbox(checked = checked, onCheckedChange = { checked = it })
}

// Ejemplo de FloatingActionButton
@Preview
@Composable
fun FloatingActionButton() {
    FloatingActionButton(onClick = { }) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}

// Ejemplo de Icon
@Preview
@Composable
fun EjemploIcon() {
    Icon(Icons.Default.Star, contentDescription = "Star Icon")
}

// Ejemplo de Image
@Preview
@Composable
fun Image() {
    Image(painter = painterResource(R.drawable.favorito),
        contentDescription = "Image")
}

// Ejemplo de ProgressBar
@Preview
@Composable
fun ProgressBar() {
    CircularProgressIndicator()
}

// Ejemplo de RadioButton
@Preview
@Composable
fun RadioButton() {
    var selected by remember { mutableStateOf(false) }
    RadioButton(selected = selected, onClick = { selected = !selected })
}

// Ejemplo de Slider
@Preview
@Composable
fun Slider() {
    var sliderValue by remember { mutableStateOf(0f) }
    Slider(value = sliderValue, onValueChange = { sliderValue = it })
}

// Ejemplo de Spacer
@Preview
@Composable
fun Spacer() {
    Spacer(modifier = Modifier.height(16.dp))
}

// Ejemplo de Switch
@Preview
@Composable
fun Switch() {
    var switched by remember { mutableStateOf(false) }
    Switch(checked = switched, onCheckedChange = { switched = it })
}

// Ejemplo de TopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopAppBar() {
    TopAppBar(title = { Text("TopAppBar Ejemplo JD") })
}


// Ejemplo de Dialog
@Preview
@Composable
fun Dialog() {
    var showDialog by remember { mutableStateOf(false) }
    Button(onClick = { showDialog = true }) {
        Text("Dialogo JD")
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            text = { Text("Nose que poner.") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Ok")
                }
            }
        )
    }
}

// Ejemplo de Divider
@Preview
@Composable
fun Divider() {
    Divider(color = Color.Gray, thickness = 1.dp)
}


// Ejemplo de LazyVerticalGrid
@Preview
@Composable
fun LazyVerticalGrid() {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(10) { index ->
            Text("Item $index", modifier = Modifier.padding(16.dp))
        }
    }
}

// Ejemplo de NavigationRail
@Preview
@Composable
fun NavigationRail() {
    NavigationRail {
        NavigationRailItem(selected = true, onClick = { }, icon = { Icon(Icons.Default.Home, contentDescription = null) })
        NavigationRailItem(selected = false, onClick = { }, icon = { Icon(Icons.Default.Favorite, contentDescription = null) })
    }
}

// Ejemplo de OutlinedTextField
@Preview
@Composable
fun OutlinedTextField() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(value = text, onValueChange = { text = it },
        label = { Text("Textoooo JD") })
}


// Ejemplo de TabRow
@Preview
@Composable
fun TabRow() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    TabRow(selectedTabIndex = selectedTabIndex) {
        Tab(selected = selectedTabIndex == 0, onClick =
        { selectedTabIndex = 0 }, text = { Text("Tab 1") })
        Tab(selected = selectedTabIndex == 1, onClick =
        { selectedTabIndex = 1 }, text = { Text("Tab 2") })
    }
}

// Ejemplo de Tooltip
@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun Tooltip() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TooltipArea(tooltip = { Text("This is a tooltip") }) {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Info, contentDescription = "Info Icon")
            }
        }
    }
}







