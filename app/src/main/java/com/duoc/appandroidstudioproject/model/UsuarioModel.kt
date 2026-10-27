package com.duoc.appandroidstudioproject.model

data class UsuarioModel(
    val nombre:String= "",
    val correo:String= "",
    val clave:String= "",
    val errores:UsuarioErrores= UsuarioErrores()
)

data class UsuarioErrores(
    val nombre:String?= null,
    val correo:String?= null,
    val clave:String?= null,
)