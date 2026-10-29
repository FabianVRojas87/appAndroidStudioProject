package com.duoc.appandroidstudioproject.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface RegistroRackDao{

    @Query("SELECT * FROM registro_rack")
    suspend fun getAll(): List<RegistroRack>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(registroRack: RegistroRack)

    @Update
    suspend fun update(registroRack: RegistroRack)

    @Delete
    suspend fun delete(registroRack: RegistroRack)
}