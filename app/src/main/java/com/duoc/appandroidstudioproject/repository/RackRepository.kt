package com.duoc.appandroidstudioproject.repository

import com.duoc.appandroidstudioproject.model.RackModelo
import com.duoc.appandroidstudioproject.remote.RetrofitInstance

class RackRepository {

    suspend fun getAll(): List<RackModelo> = RetrofitInstance.api.getRacks()

}