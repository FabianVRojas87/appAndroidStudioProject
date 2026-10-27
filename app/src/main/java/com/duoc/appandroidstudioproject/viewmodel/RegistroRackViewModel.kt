package com.duoc.appandroidstudioproject.viewmodel

import androidx.lifecycle.ViewModel
import com.duoc.appandroidstudioproject.model.RegistroRackErrores
import com.duoc.appandroidstudioproject.model.RegistroRackModel
import com.duoc.appandroidstudioproject.model.UsuarioErrores
import com.duoc.appandroidstudioproject.model.UsuarioModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegistroRackViewModel: ViewModel() {
    private val _estado = MutableStateFlow(value= RegistroRackModel())
    val estado:StateFlow<RegistroRackModel> = _estado

    fun onDescripcionChange(valor:String) {
        _estado.update { it -> it.copy( descripcion = valor, errores = it.errores.copy(descripcion = null) ) }
    }
    fun onEsAprobado(valor:Boolean) {
        _estado.update { it -> it.copy( esAprobado = valor ) }
    }


    fun validarFormulario():Boolean {
        val estadoActual = _estado.value
        val errores = RegistroRackErrores(
            descripcion = if (estadoActual.descripcion.isBlank()) "-Error-" else null,
        )
        val hayErrores:Boolean = listOfNotNull(
            errores.descripcion
        ).isNotEmpty()
        _estado.update { it -> it.copy(errores = errores) }
        return !hayErrores
    }
}