package com.example.corrutinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.corrutinas.Data.Routes
import com.example.corrutinas.ui.theme.CorrutinasTheme
import com.example.corrutinas.Model.Screen1
import com.example.corrutinas.Model.ViewModel


class MainActivity : ComponentActivity() {
    private val viewmodel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CorrutinasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.Screen1.route){
                        composable(Routes.Screen1.route){ Screen1(navController, viewmodel) }
                    }
                }
            }
        }
    }
}



/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CorrutinasTheme {
        var cambiar by rememberSaveable{ mutableStateOf(true) }
        var veces by rememberSaveable{ mutableStateOf( 0)}
        var mostrar by rememberSaveable {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Button(onClick = { cambiar = !cambiar
                             veces += 1},
                colors = ButtonDefaults.buttonColors(containerColor = if(cambiar) Color.Red else Color.Blue)
            ) {
                Text(text = "Cambiar de color")
            }
            if(mostrar)Text(text = "Respuesta de la API: $veces")
            Button(onClick = { bloqueoApp()
                             mostrar = true},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(text = "LLamar Api")
            }
        }
    }
}

fun bloqueoApp(){
    Thread.sleep(5000)
}

 */