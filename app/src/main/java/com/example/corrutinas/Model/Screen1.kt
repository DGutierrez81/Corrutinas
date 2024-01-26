package com.example.corrutinas.Model

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController



@Composable
fun Screen1(navController: NavHostController, viewModel: ViewModel){
    val cambiar: Boolean by viewModel.cambiar.observeAsState(true)
    val veces: Int by viewModel.veces.observeAsState(0)
    //var cambiar by rememberSaveable{ mutableStateOf(true) }
    //var veces by rememberSaveable{ mutableStateOf( 0)}
    var mostrar by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(onClick = { viewModel.color()},
            colors = ButtonDefaults.buttonColors(containerColor = if(cambiar) Color.Red else Color.Blue)
        ) {
            Text(text = "Cambiar de color")
        }
        if(mostrar)Text(text = "Respuesta de la API: $veces")
        Button(onClick = { viewModel.bloqueoApp()
            mostrar = true},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(text = "LLamar Api")
        }
    }
}


