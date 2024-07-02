package com.example.lassssttt

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface QandA_DAO {

    @Query("SELECT * FROM QandA ")
    fun getallqanda() : LiveData<List<QandA>>

    @Upsert
    fun Insertqanda(qandA: List<QandA>)
}