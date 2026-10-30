package com.duoc.appandroidstudioproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val nombre:String= "",
    val correo:String= "",
    val clave:String= ""
)


/*
data class UsuarioErrores(
    val nombre:String?= null,
    val correo:String?= null,
    val clave:String?= null,
)
 */