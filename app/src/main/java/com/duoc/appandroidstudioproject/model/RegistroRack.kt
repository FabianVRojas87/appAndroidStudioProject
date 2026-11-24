package com.duoc.appandroidstudioproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "registro_rack")
data class RegistroRack(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val codigo: String,
    val ubicacion: String,
    val observaciones: String,
    val fotoRuta: String,   // Ruta del archivo .jpg guardado en el celular
    val fechaDia: String,   // Ej: "24/11/2026" (para agrupar por día)
    val hora: String        // Ej: "14:35"
)


/*
data class RegistroRackErrores(
    val id:Int? = null,
    val descripcion:String? = null
)
 */