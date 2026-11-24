package com.duoc.appandroidstudioproject.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate
import java.util.Date

data class RackModelo(

    val id: Int,

    val descripcion: String,

    //@SerializedName(value = "es_aprobado")
    val es_aprobado: Boolean,

    val direccion: String,

    val modelo: String,

    val fecha: LocalDate,

    //@SerializedName(value = "usuarios_01_id")
    val usuarios_01_id: Int,
)

data class PostRackModelo(
    val descripcion: String,
    val es_aprobado: Boolean,
    val direccion: String,
    val modelo: String,
    val fecha: LocalDate,
    val usuarios_01_id: Int,
)