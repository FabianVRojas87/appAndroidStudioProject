package com.duoc.appandroidstudioproject.viewmodel

import android.util.Log
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
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

class UsuarioViewModel(): ViewModel() {

    private val repository = UsuarioRepository()
    private val _lista_usuarios = MutableStateFlow< List<UsuarioModelo> >(value = emptyList())
    val lista_usuarios: StateFlow< List<UsuarioModelo> > = _lista_usuarios

    init {
        cargarUsuarios()
    }

    private fun cargarUsuarios() {
        viewModelScope.launch {
            _lista_usuarios.value = repository.getAll()
        }
    }

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

    fun validarCredenciales(correoIngresado: String, contrasennaIngresada: String): Boolean {
        val usuarioEncontrado = lista_usuarios.value.firstOrNull { it.correo == correoIngresado }
        //Log.d("Login", "usuarioEncontrado: ${usuarioEncontrado}")
        if( usuarioEncontrado == null ){
            return false
        }else if( usuarioEncontrado.contrasenna != contrasennaIngresada ) {
            return false
        }
        return true
    }
}