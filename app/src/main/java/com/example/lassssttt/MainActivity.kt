package com.example.lassssttt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

abstract class MainActivity : AppCompatActivity() {

    private lateinit var question : TextView
    private lateinit var qustionnum : TextView
    private lateinit var rb1 : RadioButton
    private lateinit var rb2 : RadioButton
    private lateinit var rbgroup : RadioGroup

     abstract var quesioncounter :Int
    abstract var totalquestioncount :Int

    private lateinit var Qandaclass : QandA
    private lateinit var qandalist : List<QandA>

     private lateinit var questionViewModel : QandA_ViewModel

    //private val viewModel:QandA_ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionViewModel = ViewModelProvider(this).get(QandA_ViewModel::class.java)
        questionViewModel.getall().observe(this , Observer { QandA ->
            fetch(QandA)
            setquestiosn()
        })
    }

    fun startquiz(){
        //setquestiosn()
        rbgroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radio_Button1 -> {
                    rb1.background = ContextCompat.getDrawable(applicationContext, R.drawable.white)
                    rb2.background = ContextCompat.getDrawable(applicationContext, R.color.yellow)

                }
                R.id.radio_Button2 -> {
                    rb1.background = ContextCompat.getDrawable(applicationContext, R.color.yellow)
                    rb2.background = ContextCompat.getDrawable(applicationContext, R.drawable.white)
                }
            }
        }
    }

    fun fetch(qandA : List<QandA>) {
         qandalist = qandA
    }

    fun setquestiosn(){
        startquiz()
        question = findViewById(R.id.questiontxt)
        question.setText(Qandaclass.question)
        rb1= findViewById(R.id.radio_Button1)
        rb1.setText(Qandaclass.optA)
        rb2= findViewById(R.id.radio_Button2)
        rb2.setText(Qandaclass.optB)
        rbgroup = findViewById(R.id.radiogroup)

        Qandaclass = qandalist.get(quesioncounter)
        totalquestioncount = qandalist.size


    }
}