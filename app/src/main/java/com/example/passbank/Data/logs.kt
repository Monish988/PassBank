package com.example.passbank.Data

import android.media.MediaDrm.LogMessage
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "logs")
data class logs(
    @PrimaryKey(true)
    val id:Int = 0,
    val created:String,
    val message:String
)
data class LogM(
    val message:String
)