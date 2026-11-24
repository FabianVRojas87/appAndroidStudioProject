package com.duoc.appandroidstudioproject.repository

import com.duoc.appandroidstudioproject.model.UsuarioModelo
import com.duoc.appandroidstudioproject.remote.RetrofitInstance

class UsuarioRepository() {

    suspend fun getAll(): List<UsuarioModelo> = RetrofitInstance.api.getUsuarios()

}