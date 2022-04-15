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

    private lateinit var textCountry: TextView
    private lateinit var colorText: TextView
    private lateinit var colorBackground: TextView
    private lateinit var error: TextView

    private var screenCountry: Int?
        get() = textCountry.text.toString().toIntOrNull()
        set(value) {
            textCountry.text = value.toString()
        }

    private var screenTextColor: String
        get() = colorText.text.toString()
        set(value) {
            colorText.text = value
        }
    private var screenBackgroundColor: String
        get() = colorBackground.text.toString()
        set(value) {
            colorBackground.text = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_counter)

        textCountry = findViewById(R.id.value_country)
        colorText = findViewById(R.id.color_text)
        colorBackground = findViewById(R.id.color_background)
        error = findViewById(R.id.error)

        Log.d(TAG, "CreateCounterActivity создано")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "CreateCounterActivity onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "CreateCounterActivity становиться видимым")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "CreateCounterActivity получает фокус (состояние Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "CreateCounterActivity приостановлено (состояние Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "CreateCounterActivity остановлено (состояние Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "CreateCounterActivity уничтожено")
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
            error.text = null
        } else {
            error.text = "ERROR..\n Enter correct data."
        }
    }

    companion object {
        private const val TAG = "Lifecycle"

        private val COLOR_TEXT = listOf(
            "r", "g", "b", "m"
        )

        private val COLOR_BACKGROUND = listOf(
            "1", "2", "3", "4"
        )
    }

    fun btnEdit(view: View) {}
    fun btnShare(view: View) {}
}


