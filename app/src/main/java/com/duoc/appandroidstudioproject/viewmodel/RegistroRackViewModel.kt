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
}