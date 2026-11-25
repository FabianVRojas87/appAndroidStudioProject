package com.duoc.appandroidstudioproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.appandroidstudioproject.model.PostRackModelo
import com.duoc.appandroidstudioproject.model.PostUsuarioModelo
import com.duoc.appandroidstudioproject.model.RackModelo
import com.duoc.appandroidstudioproject.model.RegistroRack
import com.duoc.appandroidstudioproject.model.Usuario
import com.duoc.appandroidstudioproject.model.UsuarioModelo
import com.duoc.appandroidstudioproject.repository.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

class UsuarioViewModel(): ViewModel() {

    private val repository = UsuarioRepository()

    suspend fun agregarNuevoUsuario(nombre: String, correo: String, telefono: Int, contrasenna: String) {
        val nuevoUsuario: PostUsuarioModelo = PostUsuarioModelo(nombre, correo, telefono, contrasenna)
        viewModelScope.launch {
            repository.postUsuario(nuevoUsuario)
        }
    }

    suspend fun actualizarUsuario(id: Int, nombre: String, correo: String, telefono: Int, contrasenna: String) {
        val nuevoUsuario: UsuarioModelo = UsuarioModelo(id, nombre, correo, telefono, contrasenna)
        viewModelScope.launch {
            repository.putUsuario(idObjetivo = id, nuevoUsuario = nuevoUsuario)
        }
    }
}