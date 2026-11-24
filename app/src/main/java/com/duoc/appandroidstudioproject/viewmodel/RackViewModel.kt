package com.duoc.appandroidstudioproject.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.appandroidstudioproject.model.PostRackModelo
import com.duoc.appandroidstudioproject.model.RackModelo
import com.duoc.appandroidstudioproject.repository.RackRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDate.now

class RackViewModel: ViewModel() {

    private val repository = RackRepository()
    private val _lista_racks = MutableStateFlow< List<RackModelo> >(value = emptyList())
    val lista_racks: StateFlow< List<RackModelo> > = _lista_racks


    init {
        obtenerRacks()
    }

    private fun obtenerRacks() {
        viewModelScope.launch {
            _lista_racks.value = repository.getAll()
        }
    }

    private fun cargarRacksDeUsuario(usuarioId: Int) {
        viewModelScope.launch {
            _lista_racks.value = repository.getRacksPorUsuario(usuarioId)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun agregarNuevoRack(descripcion: String, es_aprobado: Boolean, direccion: String, modelo: String, usuarios_01_id: Int) {
        val nuevoRack: PostRackModelo = PostRackModelo(descripcion, es_aprobado, direccion, modelo,LocalDate.now(), usuarios_01_id)
        viewModelScope.launch {
            repository.postRack(nuevoRack)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun actualizarRack(id: Int, descripcion: String, es_aprobado: Boolean, direccion: String, modelo: String, usuarios_01_id: Int) {
        val nuevoRack: RackModelo = RackModelo(id, descripcion, es_aprobado, direccion, modelo,LocalDate.now(), usuarios_01_id)
        viewModelScope.launch {
            repository.putRack(idObjetivo = id, nuevoRack = nuevoRack)
        }
    }

    suspend fun eliminarRack(id: Int) {
        viewModelScope.launch {
            repository.deleteRack(idObjetivo = id)
        }
    }

}