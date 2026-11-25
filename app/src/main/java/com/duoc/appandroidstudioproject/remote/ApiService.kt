package com.duoc.appandroidstudioproject.remote

import com.duoc.appandroidstudioproject.model.PostRackModelo
import com.duoc.appandroidstudioproject.model.PostUsuarioModelo
import com.duoc.appandroidstudioproject.model.RackModelo
import com.duoc.appandroidstudioproject.model.UsuarioModelo
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("racks_01")
    suspend fun getRacks(): List<RackModelo>

    @GET("racks_por_usuario/{usuario_id}")
    suspend fun getRacksPorUsuario(@Path(value = "usuario_id") id: Int): List<RackModelo>

    @POST("racks_01")
    suspend fun postRack(@Body rack: PostRackModelo): RackModelo

    @PUT("racks_01/{id}")
    suspend fun putRack(
        @Path(value = "id") id: Int,
        @Body rack: RackModelo
    ): RackModelo

    @DELETE("rack_01/{id}")
    suspend fun deleteRack(@Path(value = "id") id: Int)



    @GET("usuarios_01")
    suspend fun getUsuarios(): List<UsuarioModelo>

    @POST("usuarios_01")
    suspend fun postUsuario(@Body usuario: PostUsuarioModelo): UsuarioModelo

    @PUT("usuarios_01/{id}")
    suspend fun putUsuario(
        @Path(value = "id") id: Int,
        @Body usuario: UsuarioModelo
    ): UsuarioModelo

    @DELETE("usuarios_01/{id}")
    suspend fun deleteUsuario(@Path(value = "id") id: Int)
}