package com.duoc.appandroidstudioproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.appandroidstudioproject.model.RackModelo
import com.duoc.appandroidstudioproject.repository.RackRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

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

}