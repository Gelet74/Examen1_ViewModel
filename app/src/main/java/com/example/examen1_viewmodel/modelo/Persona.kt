package com.example.examen1_viewmodel.modelo

open class Persona(
    open val nombre: String = ""
)

class Alumno(
    override val nombre: String = "",
    val cursoSeleccionado: String = "",
    val NIA: String = "",
    val codIden: String = ""
): Persona(nombre)

class Profesor(
    override val nombre: String = "",
    val cursosImparte: String = "",
    val esTutor: Boolean = false,
    val codigoIdent: String = ""
): Persona(nombre)