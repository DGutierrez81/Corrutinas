package com.example.corrutinas.Model
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel: ViewModel() {
    val _cambiar = MutableLiveData<Boolean>()
    val cambiar: LiveData<Boolean> = _cambiar
    val _veces = MutableLiveData<Int>()
    val veces: LiveData<Int> = _veces
    val _mostrar = MutableLiveData<Boolean>()
    val mostrar: LiveData<Boolean> = _mostrar
    var suma by mutableStateOf( 0)
    var bol by mutableStateOf( true)
    val _mensaje = MutableLiveData<String>()
    val mensaje: LiveData<String> = _mensaje



    fun getColor(cambio: Boolean): Color{
        return if(cambio) Color.Red else Color.Blue
    }
    fun color(cambio: Boolean){
        bol = !cambio
        _cambiar.value = bol
    }

    /*
    fun bloqueoApp(){
        Thread.sleep(5000)
        _mostrar.value = true
    }

     */

    fun fetchData(){
        viewModelScope.launch {
            try {
                suma += 1
                _veces.value = suma
                _mostrar.value = true
                llamarApi()
            }catch (e: Exception){
                println("Error ${e.message}")
            }finally {

            }
        }
    }

    private suspend fun llamarApi(){
        delay(5000)
        _mostrar.value = false
        _mensaje.value = "Respuesta de la API: $suma"
    }

}




