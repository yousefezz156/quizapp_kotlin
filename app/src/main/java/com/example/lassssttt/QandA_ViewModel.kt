package com.example.lassssttt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class QandA_ViewModel(application: Application) : AndroidViewModel(application) {

    private val qandaRepository : QandA_Repository
    private val getallq : LiveData<List<QandA>>

    init {
        qandaRepository = QandA_Repository(application)
        getallq = qandaRepository.fetchall()
    }

    fun getall(): LiveData<List<QandA>>{
        return getallq
    }
}