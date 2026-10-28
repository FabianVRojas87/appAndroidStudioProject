package com.duoc.appandroidstudioproject.model

data class RegistroRack(
    val id:Int = 0,
    val descripcion:String = "",
    val esAprobado:Boolean = false,
    val errores:RegistroRackErrores= RegistroRackErrores()
)

data class RegistroRackErrores(
    val id:Int? = null,
    val descripcion:String? = null
)