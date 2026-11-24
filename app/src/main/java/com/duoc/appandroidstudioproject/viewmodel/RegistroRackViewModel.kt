package com.duoc.appandroidstudioproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.appandroidstudioproject.model.RegistroRack
import com.duoc.appandroidstudioproject.repository.RegistroRackRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistroRackViewModel(
    private val repository: RegistroRackRepository
): ViewModel() {
    val registrosRacks = MutableStateFlow< List<RegistroRack> >(emptyList())
    val descripcion = MutableStateFlow("")
    val esAprobado = MutableStateFlow(false)

    init {
        cargarRegistrosRacks()
    }

    private fun  cargarRegistrosRacks() {
        viewModelScope.launch{ registrosRacks.value = repository.getAll() }
    }

    fun agregarRegistroRack(registroRack: RegistroRack) {
        viewModelScope.launch {
            repository.insert(registroRack)
            cargarRegistrosRacks()
        }
    }

    fun actualizarRegistroRack(registroRack: RegistroRack) {
        viewModelScope.launch {
            repository.update(registroRack)
            cargarRegistrosRacks()
        }
    }

    fun eliminarRegistroRack(registroRack: RegistroRack) {
        viewModelScope.launch {
            repository.delete(registroRack)
            cargarRegistrosRacks()
        }
    }
    // --- HISTORIAL DE RACKS CON FOTO ---
    val historialFotos = androidx.compose.runtime.mutableStateListOf<RegistroFotoRack>()

    fun registrarFotoRack(
        foto: android.graphics.Bitmap,
        codigo: String,
        ubicacion: String,
        observaciones: String
    ) {
        val formato = java.text.SimpleDateFormat("dd/MM/yyyy HH:mm", java.util.Locale.getDefault())
        val fechaHoraActual = formato.format(java.util.Date())

        historialFotos.add(
            0,
            RegistroFotoRack(
                id = System.currentTimeMillis(),
                foto = foto,
                codigo = codigo,
                ubicacion = ubicacion,
                observaciones = observaciones,
                fechaHora = fechaHoraActual
            )
        )
    }

    fun editarFotoRack(id: Long, nuevoCodigo: String, nuevaUbicacion: String, nuevasObs: String) {
        val index = historialFotos.indexOfFirst { it.id == id }
        if (index != -1) {
            historialFotos[index] = historialFotos[index].copy(
                codigo = nuevoCodigo,
                ubicacion = nuevaUbicacion,
                observaciones = nuevasObs
            )
        }
    }
}
data class RegistroFotoRack(
    val id: Long,
    val foto: android.graphics.Bitmap,
    val codigo: String,
    val ubicacion: String,
    val observaciones: String,
    val fechaHora: String
)