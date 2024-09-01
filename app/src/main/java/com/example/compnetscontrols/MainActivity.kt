package com.example.compnetscontrols

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            Text(text = "Elemento $index", modifier = Modifier.padding(8.dp))
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
        modifier = Modifier.padding(16.dp)
    ) {
        items(10) { index ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Elemento $index", color = MaterialTheme.colorScheme.onPrimary)
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
                    start.linkTo(parent.start, margin = 16.dp)
                }
                .padding(8.dp)
        )

        Text(
            text = "Texto 2",
            modifier = Modifier
                .constrainAs(text2) {
                    top.linkTo(text1.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
                .padding(8.dp)
        )

        Text(
            text = "Texto 3",
            modifier = Modifier
                .constrainAs(text3) {
                    top.linkTo(text2.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
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
            text = "Welcome to the Course!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Hello, Student!",
            fontSize = 20.sp
        )
    }
}






