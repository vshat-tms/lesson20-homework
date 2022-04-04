package com.example.lessson17

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CreateCounter : AppCompatActivity() {

    private lateinit var valuesCounter: EditText
    private lateinit var colorText: EditText
    private lateinit var numberBackground: EditText
    private lateinit var errorText: TextView
    private lateinit var buttonCreate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter_create)

        valuesCounter = findViewById(R.id.counter_value)
        colorText = findViewById(R.id.color_text)
        numberBackground = findViewById(R.id.number_background)
        errorText = findViewById(R.id.text_error)
        buttonCreate = findViewById(R.id.button_create)

        buttonCreate.setOnClickListener {
            errorText.text = BLANK_FIELD
            createACounter()
        }
        Log.d(TAG_TWO, "Create Counter create")
    }

    private fun createACounter() {
        val intent = Intent(this, CounterActivity::class.java)

        val one = checkColorText()
        val two = checkValuesCounter()
        val three = checkNumberBackground()
        Log.d(TAG, "color $one")
        Log.d(TAG, "counter $two")
        Log.d(TAG, "background $three")

        if (!checkValuesCounter()) {
            intent.putExtra("valuesCounter", valuesCounter.text.toString())
        } else {
            valuesCounter.text.clear()
            errorText.text = "ERROR values counter integer"
        }
        if (checkColorText()) {
            intent.putExtra("valuesColor", colorText.text.toString())
        } else {
            colorText.text.clear()
            errorText.text = "${errorText.text}\n ERROR values color text R, G, B or M"
        }
        if (checkNumberBackground()) {
            intent.putExtra("numberBackground", numberBackground.text.toString())
        } else {
            numberBackground.text.clear()
            errorText.text = "${errorText.text}\n ERROR values number background 1 - 4"
        }
        if (errorText.text == BLANK_FIELD) {
            startActivity(intent)
        } else {
            errorText.text = "${errorText.text}\n Repeat the entry"
        }
    }

    private fun checkValuesCounter(): Boolean {
        val values = valuesCounter.text.toString().toIntOrNull()
        Log.d(TAG, "values counter = $values")
        return (valuesCounter.toString().isEmpty() || values == null)
    }

    private fun checkColorText(): Boolean {
        Log.d(TAG, "color = ${colorText.text}")
        return when (colorText.text.toString().lowercase()) {
            "r" -> true
            "g" -> true
            "b" -> true
            "m" -> true
            else -> false
        }
    }

    private fun checkNumberBackground(): Boolean {
        val values = numberBackground.text.toString().toIntOrNull()
        Log.d(TAG, "values background = $values")
        return (numberBackground.text.isNotEmpty() || values in 1..4)
    }

    companion object {
        private const val TAG = "myBug"
        private const val TAG_TWO = "lifecycle"
        private const val BLANK_FIELD = ""
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG_TWO, "Create Counter start")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG_TWO, "Create Counter pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG_TWO, "Create Counter stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG_TWO, "Create Counter destroy")
    }
}