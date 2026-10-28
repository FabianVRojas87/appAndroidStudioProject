package com.duoc.appandroidstudioproject.model

data class Usuario(
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