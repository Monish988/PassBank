package com.example.passbank.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("passwords")
data class Pass(
    @PrimaryKey(true)
    val id:Int = 0,
    val email:String,
    val password:String,
    val platform:String
)
