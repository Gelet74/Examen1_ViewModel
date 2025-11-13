package com.example.examen1_viewmodel.ui.appViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.examen1_viewmodel.modelo.AppUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.examen1_viewmodel.modelo.Rol

class AppViewModel : ViewModel() {

    private val _appUIState = MutableStateFlow(AppUIState())
    val appUIState: StateFlow<AppUIState> = _appUIState.asStateFlow()

    var nombreSeleccionado by mutableStateOf("")
        private set

    var cursoMatSeleccionado by mutableStateOf("")
        private set

    var NIASeleccionado by mutableStateOf("")
        private set

     var codIden by mutableStateOf("")
        private set

        var codigoIdent by mutableStateOf("")
        private set

    var cursosImpaSeleccionado by mutableStateOf("")
        private set

    var esTutor by mutableStateOf(false)
        private set


    fun actualizarNombre(nuevo: String) {
        nombreSeleccionado = nuevo
    }

    fun actualizarNIA(nuevo: String) {
        NIASeleccionado = nuevo
    }

    fun actualizarCodIden(nuevoCodigo: String) {
        codIden = nuevoCodigo
    }

    fun actualizarCodigoIdent(nuevoCodigo: String) {
        codigoIdent = nuevoCodigo
    }

    fun actualizarEsTutor(valor: Boolean) {
        esTutor = valor
    }

    fun generarCodigoAlumno(nombre: String, NIA: String): String {
        val n = NIA.trim()
        if (n.length != 5 || n == "00000" || !n.all { it.isDigit() }) return ""
        val ultimaLetra = if (nombre.isNotBlank()) nombre.trim().last().toString() else ""
        val impares = n.filterIndexed { i, _ -> i % 2 != 0 }
        return ultimaLetra + impares
    }

    fun generarCodigoProfesor(nombre: String, esTutor: Boolean): String {
        val n = nombre.trim()
        if (n.isEmpty()) return ""
        val invertido = n.reversed()
        val tutorTxt = if (esTutor) "SI" else "NO"
        return invertido + tutorTxt
    }

    var rolSeleccionado by mutableStateOf(Rol.ALUMNO)
        private set
    fun actualizarRol(nuevo: Rol) { rolSeleccionado = nuevo }

    var cursoSeleccionado by mutableStateOf("")
        private set
    fun actualizarCurso(nuevo: String) { cursoSeleccionado = nuevo }

    fun actualizarTutor(nuevo: Boolean) {
        esTutor = nuevo
    }
}
