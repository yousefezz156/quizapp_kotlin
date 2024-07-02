package com.example.lassssttt

import android.app.Application
import androidx.lifecycle.LiveData

class QandA_Repository(application: Application) {

private val qandaDao : QandA_DAO
private val getall : LiveData<List<QandA>>

init {
    val db = QandA_DataBase.getinstance( application)
    qandaDao = db.qandadao()
    getall = qandaDao.getallqanda()
}
     fun fetchall() : LiveData<List<QandA>> {
        return getall
    }

}