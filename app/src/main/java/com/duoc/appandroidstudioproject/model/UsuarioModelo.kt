package com.duoc.appandroidstudioproject.model

data class UsuarioModelo(

    val id: Int,

    val nombre: String,

    val correo: String,

    val telefono: Int,

    val contrasenna: String
)

data class PostUsuarioModelo(
    val nombre:String,
    val correo:String,
    val telefono:Int,
    val contrasena:String
)