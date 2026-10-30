package com.duoc.appandroidstudioproject.repository

import com.duoc.appandroidstudioproject.model.RegistroRack
import com.duoc.appandroidstudioproject.model.RegistroRackDao
import com.duoc.appandroidstudioproject.model.Usuario
import com.duoc.appandroidstudioproject.model.UsuarioDao

class UsuarioRepository(private val dao: UsuarioDao) {
    suspend fun getAll() = dao.getAll()
    suspend fun insert(usuario: Usuario) = dao.insert(usuario)
    suspend fun update(usuario: Usuario) = dao.update(usuario)
    suspend fun delete(usuario: Usuario) = dao.delete(usuario)
}