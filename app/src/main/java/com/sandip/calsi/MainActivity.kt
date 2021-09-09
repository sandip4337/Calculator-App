package com.sandip.calsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    //operators
    lateinit var openbracket : Button
    lateinit var closebracket : Button
    lateinit var divition : Button
    lateinit var  multiplication: Button
    lateinit var addition : Button
    lateinit var difference : Button
    lateinit var allclear: Button
    lateinit var back: Button
    lateinit var equal: Button

    lateinit var toolbar: Toolbar

    //numbers
    lateinit var one : Button
    lateinit var two : Button
    lateinit var three : Button
    lateinit var four : Button
    lateinit var five : Button
    lateinit var six : Button
    lateinit var seven : Button
    lateinit var eight : Button
    lateinit var nine : Button
    lateinit var zero : Button
    lateinit var dot : Button


    lateinit var input: TextView
    lateinit var output: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = " CalSI"

        input = findViewById(R.id.input)
        output = findViewById(R.id.output)
        one = findViewById(R.id.btn_1)
        two = findViewById(R.id.btn_2)
        three = findViewById(R.id.btn_3)
        four = findViewById(R.id.btn_4)
        five = findViewById(R.id.btn_5)
        six = findViewById(R.id.btn_6)
        seven = findViewById(R.id.btn_7)
        eight = findViewById(R.id.btn_8)
        nine = findViewById(R.id.btn_9)
        zero = findViewById(R.id.btn_0)
        dot = findViewById(R.id.btndot)

        openbracket = findViewById(R.id.btn_openbracket)
        closebracket = findViewById(R.id.btn_closebracket)
        divition = findViewById(R.id.btn_divide)
        multiplication = findViewById(R.id.btn_multiplication)
        addition = findViewById(R.id.btn_plus)
        difference = findViewById(R.id.btn_minus)
        allclear = findViewById(R.id.btn_AC)
        back = findViewById(R.id.btnback)
        equal = findViewById(R.id.btn_equal)

        //numbers
        zero.setOnClickListener { appendOnExpresstion("0",true) }
        one.setOnClickListener { appendOnExpresstion("1",true) }
        two.setOnClickListener { appendOnExpresstion("2",true) }
        three.setOnClickListener { appendOnExpresstion("3",true) }
        four.setOnClickListener { appendOnExpresstion("4",true) }
        five.setOnClickListener { appendOnExpresstion("5",true) }
        six.setOnClickListener { appendOnExpresstion("6",true) }
        seven.setOnClickListener { appendOnExpresstion("7",true) }
        eight.setOnClickListener { appendOnExpresstion("8",true) }
        nine.setOnClickListener { appendOnExpresstion("9",true) }
        dot.setOnClickListener { appendOnExpresstion(".",true) }

        //oparators
        openbracket.setOnClickListener { appendOnExpresstion("(",false) }
        closebracket.setOnClickListener { appendOnExpresstion(")",false) }
        divition.setOnClickListener { appendOnExpresstion("/",false) }
        multiplication.setOnClickListener { appendOnExpresstion("*",false) }
        addition.setOnClickListener { appendOnExpresstion("+",false) }
        difference.setOnClickListener { appendOnExpresstion("-",false) }


        allclear.setOnClickListener {

            input.text = ""
            output.text = ""

        }

        back.setOnClickListener {

            val string = input.text.toString()
            if (string.isNotEmpty()){
                input.text = string.substring(0,string.length-1)
            }
            output.text = ""

        }

        equal.setOnClickListener {
            try {
                val expression = ExpressionBuilder(input.text.toString()).build()
                val result = expression.evaluate()
                val longresult = result.toLong()

                if (result == longresult.toDouble()){
                    output.text = longresult.toString()
                }
                else{
                    output.text = result.toString()
                }

        }catch(e:Exception){

            Log.d("Exception","message : "+ e.message)

            }

        }


    }

    fun appendOnExpresstion(string: String , canClear : Boolean) {

        if (output.text.isNotEmpty()){
            input.text = ""
        }

        if (canClear){
            output.text = ""
            input.append(string)
        }else{
            input.append(output.text)
            input.append(string)
            output.text = ""
        }
    }
}