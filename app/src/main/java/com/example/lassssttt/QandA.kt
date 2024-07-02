package com.example.lassssttt

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QandA(
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    val question: String,
    val optA: String,
    val optB: String,
    val answer : Int
)
