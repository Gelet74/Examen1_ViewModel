package com.example.examen1_viewmodel.modelo

data class AppUIState (

   val alumnos: List<Alumno> = emptyList(),
    val profesores: List<Profesor> = emptyList()
)