package com.example.lassssttt

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database( entities = arrayOf(QandA::class) , version = 1)
abstract class QandA_DataBase : RoomDatabase(){

    abstract fun qandadao() : QandA_DAO

    companion object{
        @Volatile
        private var INSTANCE : QandA_DataBase? = null

         fun getinstance( context: Context) : QandA_DataBase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: BuildDatabase(context).also { INSTANCE = it}

        }
        private fun BuildDatabase(context: Context) : QandA_DataBase{
             return Room.databaseBuilder(context.applicationContext ,
                QandA_DataBase::class.java ,
                "sample.db").addCallback(object :Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    ioThread{
                        getinstance(context).qandadao().Insertqanda(prepopulatedata())
                    }

                }
                }).build()
        }
        private fun prepopulatedata()  : List<QandA>{
            return listOf(QandA(1, "hello", "word", "words", 1),
                   QandA(2, "helloo", "wordsss", "words", 2))
        }

        fun ioThread(f: () -> Unit) {
            CoroutineScope(Dispatchers.IO).launch {
                f()
            }
        }



    }
}