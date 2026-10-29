package com.duoc.appandroidstudioproject.repository

import com.duoc.appandroidstudioproject.model.RegistroRack
import com.duoc.appandroidstudioproject.model.RegistroRackDao

class RegistroRackRepository(private val dao: RegistroRackDao) {
    suspend fun getAll() = dao.getAll()
    suspend fun insert(registroRack:RegistroRack) = dao.insert(registroRack)
    suspend fun update(registroRack:RegistroRack) = dao.update(registroRack)
    suspend fun delete(registroRack:RegistroRack) = dao.delete(registroRack)
}