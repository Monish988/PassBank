package com.example.passbank.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PassDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pass: Pass)
    @Delete
    suspend fun delete(pass: Pass)
    @Update
    suspend fun update(pass: Pass)


    @Query("SELECT * FROM passwords")
    fun getalldata():Flow<List<Pass>>
}