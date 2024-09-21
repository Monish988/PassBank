package com.example.passbank.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Pass::class,logs::class],
    version = 1,
    exportSchema = false

)
abstract class Passdatabase:RoomDatabase(){
    abstract fun Passdao():PassDao
    abstract fun LogsDAO():LogsDAO
}