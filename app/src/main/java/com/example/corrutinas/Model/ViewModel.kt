package com.example.corrutinas.Model
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    fun bloqueoApp(){
        Thread.sleep(5000)
    }
}