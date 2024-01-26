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
import androidx.compose.material3.CircularProgressIndicator
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
    val veces: Int by viewModel.veces.observeAsState(1)
    val mostrar: Boolean by viewModel.mostrar.observeAsState(false)
    val mensaje: String by viewModel.mensaje.observeAsState("")
    //var cambiar by rememberSaveable{ mutableStateOf(true) }
    //var veces by rememberSaveable{ mutableStateOf( 0)}

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(onClick = { viewModel.color(viewModel.bol)},
            colors = ButtonDefaults.buttonColors(containerColor = viewModel.getColor(cambiar))
        ) {
            Text(text = "Cambiar de color")
        }

        if(mostrar) {
            CircularProgressIndicator()
        }else Text(text = mensaje)

        Button(onClick = { viewModel.fetchData()},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(text = "LLamar Api")
        }
    }
}


