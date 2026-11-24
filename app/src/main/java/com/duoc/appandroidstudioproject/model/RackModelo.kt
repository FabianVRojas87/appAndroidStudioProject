package com.duoc.appandroidstudioproject.model

import com.google.gson.annotations.SerializedName

data class RackModelo(

    val id: Int,

    val descripcion: String,

    //@SerializedName(value = "es_aprobado")
    val es_aprobado: Boolean,

    val direccion: String,

    val modelo: String,

    //@SerializedName(value = "usuarios_01_id")
    val usuarios_01_id: Int,
)