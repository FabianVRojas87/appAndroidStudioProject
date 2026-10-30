package com.duoc.appandroidstudioproject.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RegistroRack::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun registroRackDao():RegistroRackDao
    //abstract fun usuarioDao(): UsuarioDao
}