package com.example.lessson17

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class CreateCounterActivity : AppCompatActivity() {

    private lateinit var textCountryNumber: TextView
    private lateinit var colorTextChar: TextView
    private lateinit var colorBackgroundNumber: TextView
    private lateinit var error: TextView

    private var screenCountry: Int?
        get() = textCountryNumber.text.toString().toIntOrNull()
        set(value) {
            textCountryNumber.text = value.toString()
        }

    private var screenTextColor: String
        get() = colorTextChar.text.toString()
        set(value) {
            colorTextChar.text = value
        }
    private var screenBackgroundColor: String
        get() = colorBackgroundNumber.text.toString()
        set(value) {
            colorBackgroundNumber.text = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_counter)

        textCountryNumber = findViewById(R.id.value_country)
        colorTextChar = findViewById(R.id.color_text)
        colorBackgroundNumber = findViewById(R.id.color_background)
        error = findViewById(R.id.error)
    }

    fun create(view: View) {
        val intentScreenCounter = Intent(this, ScreenCounterActivity::class.java)
        intentScreenCounter.putExtra("valueCountry", screenCountry)
        intentScreenCounter.putExtra("colorText", screenTextColor)
        intentScreenCounter.putExtra("colorBackground", screenBackgroundColor)
        if (screenCountry is Int &&
            screenTextColor in COLOR_TEXT && !screenTextColor.isEmpty() &&
            screenBackgroundColor in COLOR_BACKGROUND && !screenBackgroundColor.isEmpty()
        ) {
            startActivity(intentScreenCounter)
        } else {
            error.text = "Ошибка.. Введите корректные данные."
        }
        Log.d(TAG, "value: $screenCountry, " +
                "color text: $screenTextColor, " +
                "color background: $screenBackgroundColor.")
    }

    companion object {
        private const val TAG = "CreateCounterActivity"

        private val COLOR_TEXT = listOf(
            "r", "g", "b", "m"
        )

        private val COLOR_BACKGROUND = listOf(
            "1", "2", "3", "4"
        )
    }
}


