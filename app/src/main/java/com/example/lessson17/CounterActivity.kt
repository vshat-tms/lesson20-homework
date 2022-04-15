package com.example.lessson17

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CounterActivity : AppCompatActivity() {
    private var counter = 0
    private var colorText = 0
    private var colorBackground = 0

    private lateinit var infoTextView: TextView
    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        val savedCounter = savedInstanceState?.getInt(INFO_TEXT)
        val savedColorText = savedInstanceState?.getInt(INFO_TEXT_COLOR)
        val savedColorBackground = savedInstanceState?.getInt(BACKGROUND_COLOR)

        rootView = findViewById(R.id.root)
        infoTextView = findViewById(R.id.tv_info)

        if (savedCounter != null) {
            updateCounter(savedCounter)
        }

        if (savedColorText != 0 && savedColorText != null) {
            infoTextView.setTextColor(resources.getColor(savedColorText))
            colorText = savedColorText
        }

        if (savedColorBackground != 0 && savedColorBackground != null) {
            rootView.setBackgroundColor(resources.getColor(savedColorBackground))
            colorBackground = savedColorBackground
        }

        Log.d(TAG, "CounterActivity создано")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "CounterActivity onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "CounterActivity становиться видимым")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "CounterActivity получает фокус (состояние Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "CounterActivity приостановлено (состояние Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "CounterActivity остановлено (состояние Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "CounterActivity уничтожено")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(INFO_TEXT, counter)
        outState.putInt(INFO_TEXT_COLOR, colorText)
        outState.putInt(BACKGROUND_COLOR, colorBackground)
    }

    private fun updateCounter(value: Int) {
        counter = value
        infoTextView.text = value.toString()
    }

    fun setInfoValue(view: View) {
        when ((view as Button).text) {
            "+" -> updateCounter(counter + 1)
            "-" -> updateCounter(counter - 1)
            "0" -> updateCounter(0)
            else -> updateCounter((MIN_VALUE_RANDOM..MAX_VALUE_RANDOM).random())
        }
    }

    fun setColorText(view: View) {
        colorText = when ((view as Button).text) {
            "r" -> R.color.btn_color_r
            "g" -> R.color.btn_color_g
            "b" -> R.color.btn_color_b
            else -> R.color.btn_color_m
        }
        infoTextView.setTextColor(resources.getColor(colorText))
    }

    fun setBg(view: View) {
        colorBackground = when ((view as Button).text) {
            "1" -> R.color.btn_color_1
            "2" -> R.color.btn_color_2
            "3" -> R.color.btn_color_3
            else -> R.color.btn_color_4
        }
        rootView.setBackgroundColor(resources.getColor(colorBackground))
    }

    companion object {
        private const val MIN_VALUE_RANDOM = -100
        private const val MAX_VALUE_RANDOM = 100

        private const val INFO_TEXT = "infoText"
        private const val INFO_TEXT_COLOR = "infoTextColor"
        private const val BACKGROUND_COLOR = "backgroudColor"

        private const val TAG = "Lifecycle"
    }
}