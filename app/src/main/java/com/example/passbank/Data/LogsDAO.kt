package com.example.passbank.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface LogsDAO {





    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertlog(log:logs)




    @Delete
    suspend fun deletelog(log: logs)


    @Query("SELECT * FROM logs")
    fun getalllogs():Flow<List<logs>>

    @Query("DELETE FROM logs")
    suspend fun deletealllogs()


}