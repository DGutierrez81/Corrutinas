package com.example.corrutinas.Data

sealed class Routes(val route: String) {
    object Screen1: Routes("screen1")
}