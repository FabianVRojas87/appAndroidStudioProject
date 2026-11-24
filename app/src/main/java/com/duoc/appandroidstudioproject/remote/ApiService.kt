package com.duoc.appandroidstudioproject.remote

import com.duoc.appandroidstudioproject.model.RackModelo
import com.duoc.appandroidstudioproject.model.UsuarioModelo
import retrofit2.http.GET

interface ApiService {

    @GET("racks_01")
    suspend fun getRacks(): List<RackModelo>

    @GET("usuarios_01")
    suspend fun getUsuarios(): List<UsuarioModelo>
}