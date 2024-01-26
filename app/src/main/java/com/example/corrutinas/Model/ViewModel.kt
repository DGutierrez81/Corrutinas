package com.example.corrutinas.Model
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    val _cambiar = MutableLiveData<Boolean>()
    val cambiar: LiveData<Boolean> = _cambiar
    val _veces = MutableLiveData<Int>()
    val veces: LiveData<Int> = _veces

    fun color(){
        _cambiar.value = true
        _veces.value = _veces.value?.plus(1)
    }
    fun bloqueoApp(){
        Thread.sleep(5000)
    }
}