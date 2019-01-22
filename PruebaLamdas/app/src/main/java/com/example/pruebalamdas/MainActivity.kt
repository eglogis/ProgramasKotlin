package com.example.pruebalamdas

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener{

            val text = textInput.text.toString()
            val number = if(text.count() > 0) text.toInt() else 0

            processNumber(number,
                executeIfIsPair = {

                textInput.setTextColor(Color.RED)

            }, executeIfNot = {

                textInput.setTextColor(Color.GREEN)

            })
        }


        executeInBackground { factorial(900000000) }

    }

    private inline fun executeInBackground(crossinline function: () -> Unit) {
        Thread{ function() }.start()
    }

    private inline fun executeIfIsNougatOrAbove(function: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            function()
        }
    }

    private inline fun processNumber(number: Int, executeIfIsPair: () -> Unit,
                                     executeIfNot: () -> Unit) {
        if (number % 2 == 0) executeIfIsPair() else executeIfNot()
    }

    private fun factorial(number: Int): Long {
        val init = Calendar.getInstance().timeInMillis
        var result: Long = 1
        for (i in 1..number) {
            result *= i.toLong()
        }
        val end = Calendar.getInstance().timeInMillis
        Log.d("Factorial", "Tiempo de cálculo: " + (end - init))
        return result
    }
}
