package com.example.corrutinas.Model
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    val _cambiar = MutableLiveData<Boolean>()
    val cambiar: LiveData<Boolean> = _cambiar
    val _veces = MutableLiveData<Int>()
    val veces: LiveData<Int> = _veces
    val _mostrar = MutableLiveData<Boolean>()
    val mostrar: LiveData<Boolean> = _mostrar
    var suma by mutableStateOf( 3)



    fun getColor(cambio: Boolean): Color{
        return if(cambio) Color.Red else Color.Blue
    }
    fun color(numero: Int){
        suma += 1
        _veces.value = suma
        if(numero%2 == 0)_cambiar.value = true else _cambiar.value = false
    }
    fun bloqueoApp(){
        Thread.sleep(5000)
        _mostrar.value = true
    }
}


