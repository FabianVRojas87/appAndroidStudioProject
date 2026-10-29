package com.duoc.appandroidstudioproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "registro_rack")
data class RegistroRack(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val descripcion:String = "",
    val esAprobado:Boolean = false
)


/*
data class RegistroRackErrores(
    val id:Int? = null,
    val descripcion:String? = null
)
 */