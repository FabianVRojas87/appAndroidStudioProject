package com.duoc.appandroidstudioproject.repository

import com.duoc.appandroidstudioproject.model.PostRackModelo
import com.duoc.appandroidstudioproject.model.PostUsuarioModelo
import com.duoc.appandroidstudioproject.model.RackModelo
import com.duoc.appandroidstudioproject.model.Usuario
import com.duoc.appandroidstudioproject.model.UsuarioModelo
import com.duoc.appandroidstudioproject.remote.RetrofitInstance

class UsuarioRepository() {

    suspend fun getAll(): List<UsuarioModelo> {
        return RetrofitInstance.api.getUsuarios()
    }

    suspend fun postUsuario(nuevoUsuario: PostUsuarioModelo): UsuarioModelo {
        return RetrofitInstance.api.postUsuario(nuevoUsuario)
    }

    suspend fun putUsuario(idObjetivo: Int, nuevoUsuario: UsuarioModelo): UsuarioModelo {
        return RetrofitInstance.api.putUsuario(idObjetivo, nuevoUsuario)
    }

}