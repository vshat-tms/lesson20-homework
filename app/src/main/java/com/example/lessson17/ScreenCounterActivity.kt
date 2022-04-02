package com.example.lessson17

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ScreenCounterActivity : AppCompatActivity() {

    private lateinit var valueScreenCounter: TextView
    private lateinit var colorBackground: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_counter)

        valueScreenCounter = findViewById(R.id.valueScreenCounter)
        colorBackground = findViewById(R.id.root)

        valueScreen()
        colorTextScreen()
        colorBackgroundScreen()
    }

    fun valueScreen() {
        val intentValue = Intent(intent)
        val value = intentValue.getIntExtra("valueCountry",0)
        valueScreenCounter.text = value.toString()
    }

    fun colorTextScreen() {
        val intentColorText = Intent(intent)
        val colorText = when (intentColorText.getStringExtra("colorText")) {
            "r" -> valueScreenCounter.setTextColor(Color.RED)
            "g" -> valueScreenCounter.setTextColor(Color.GREEN)
            "b" -> valueScreenCounter.setTextColor(Color.BLUE)
            else -> valueScreenCounter.setTextColor(Color.MAGENTA)
        }
    }

    fun colorBackgroundScreen() {
        val intentColorBackground = Intent(intent)
        val colorBack = when (intentColorBackground.getStringExtra("colorBackground")) {
            "1" -> colorBackground.setBackgroundColor(Color.GRAY)
            "2" -> colorBackground.setBackgroundColor(Color.YELLOW)
            "3" -> colorBackground.setBackgroundColor(Color.BLACK)
            else -> colorBackground.setBackgroundColor(Color.DKGRAY)
        }
    }
}