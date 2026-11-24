package com.duoc.appandroidstudioproject.repository

import com.duoc.appandroidstudioproject.model.PostRackModelo
import com.duoc.appandroidstudioproject.model.RackModelo
import com.duoc.appandroidstudioproject.remote.RetrofitInstance

class RackRepository {

    suspend fun getAll(): List<RackModelo> {
        return RetrofitInstance.api.getRacks()
    }

    suspend fun getRacksPorUsuario(usuarioId: Int): List<RackModelo> {
        return RetrofitInstance.api.getRacksPorUsuario(usuarioId)
    }

    suspend fun postRack(nuevoRack: PostRackModelo): RackModelo {
        return RetrofitInstance.api.postRack(nuevoRack)
    }

    suspend fun putRack(idObjetivo: Int, nuevoRack: RackModelo): RackModelo {
        return RetrofitInstance.api.putRack(idObjetivo, nuevoRack)
    }

    suspend fun deleteRack(idObjetivo: Int) {
        RetrofitInstance.api.deleteRack(idObjetivo)
    }

}