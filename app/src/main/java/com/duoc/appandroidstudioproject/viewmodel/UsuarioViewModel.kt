package com.duoc.appandroidstudioproject.viewmodel

import androidx.lifecycle.ViewModel
import com.duoc.appandroidstudioproject.model.UsuarioErrores
import com.duoc.appandroidstudioproject.model.UsuarioModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UsuarioViewModel: ViewModel() {
    private val _estado = MutableStateFlow(value= UsuarioModel())
    val estado:StateFlow<UsuarioModel> = _estado

    fun onNombreChange(valor:String) {
        _estado.update { it -> it.copy( nombre = valor, errores = it.errores.copy(nombre = null) ) }
    }

    fun onCorreoChange(valor:String) {
        _estado.update { it -> it.copy( correo = valor, errores = it.errores.copy(correo = null) ) }
    }

    fun onClaveChange(valor:String) {
        _estado.update { it -> it.copy( clave = valor, errores = it.errores.copy(clave = null) ) }
    }


    fun validarFormulario():Boolean {
        val estadoActual = _estado.value
        val errores = UsuarioErrores(
            nombre = if (estadoActual.nombre.isBlank()) "-Error-" else null,
            correo = if (!estadoActual.correo.contains(other = "@")) "-Error-" else null,
            clave = if (estadoActual.clave.length < 6) "-Error-" else null,
        )
        val hayErrores:Boolean = listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave
        ).isNotEmpty()
        _estado.update { it -> it.copy(errores = errores) }
        return !hayErrores
    }
}