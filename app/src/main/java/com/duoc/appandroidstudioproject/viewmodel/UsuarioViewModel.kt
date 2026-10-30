package com.duoc.appandroidstudioproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.appandroidstudioproject.model.RegistroRack
import com.duoc.appandroidstudioproject.model.Usuario
import com.duoc.appandroidstudioproject.repository.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UsuarioViewModel(
    private val repository: UsuarioRepository
): ViewModel() {
    val usuarios = MutableStateFlow< List<Usuario> >(emptyList())
    val nombre = MutableStateFlow("")
    val correo = MutableStateFlow("")
    val clave = MutableStateFlow("")

    init {
        cargarUsuarios()
    }

    private fun  cargarUsuarios() {
        viewModelScope.launch{ usuarios.value = repository.getAll() }
    }

    fun agregarUsuario(usuario: Usuario) {
        viewModelScope.launch {
            repository.insert(usuario)
            cargarUsuarios()
        }
    }

    fun actualizarUsuario(usuario: Usuario) {
        viewModelScope.launch {
            repository.update(usuario)
            cargarUsuarios()
        }
    }

    fun eliminarUsuario(usuario: Usuario) {
        viewModelScope.launch {
            repository.delete(usuario)
            cargarUsuarios()
        }
    }
}