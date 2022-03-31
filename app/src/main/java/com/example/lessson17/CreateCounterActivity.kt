package com.example.lessson17

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreateCounterActivity : AppCompatActivity() {
    private lateinit var createCounterButton: Button
    private lateinit var counterSetText: EditText
    private lateinit var colorSetText: EditText
    private lateinit var backgroundSetText: EditText
    private lateinit var errorMessage: TextView
    private var errors = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_counter)
        Log.d(TAG, "onCreate")

        createCounterButton = findViewById(R.id.create)
        createCounterButton.setOnClickListener {
            checkCounterText()
            checkColorText()
            checkBackgroundText()
            if (errors.isEmpty()) {
                val intent = Intent(this, CounterActivity::class.java)
                intent.putExtra(
                    CounterActivity.PARAM_COUNTER,
                    counterSetText.text.toString().toInt()
                )
                intent.putExtra(
                    CounterActivity.PARAM_COLOR,
                    colorSetText.text.toString().lowercase()
                )
                intent.putExtra(CounterActivity.PARAM_BACKGROUND, backgroundSetText.text.toString())
                startActivity(intent)
            } else {
                val error = errors.toString()
                errorMessage.text = error
                errors = mutableListOf()
                return@setOnClickListener
            }
        }
        counterSetText = findViewById(R.id.counter_set_text)
        colorSetText = findViewById(R.id.color_set_text)
        backgroundSetText = findViewById(R.id.background_set_text)
        errorMessage = findViewById(R.id.counter_error_message)
    }

    private fun checkCounterText(): Boolean {
        val counterValue = counterSetText.text.toString().toIntOrNull()
        return if (counterValue == null) {
            errors.add(COUNTER_ERROR_MESSAGE)
            false
        } else true
    }

    private fun checkColorText(): Boolean {
        val color = colorSetText.text.toString()
        return if (!colors.contains(color)) {
            errors.add(COLOR_ERROR_MESSAGE)
            false
        } else true
    }

    private fun checkBackgroundText(): Boolean {
        val backgroundValue = backgroundSetText.text.toString().toIntOrNull()
        return if (backgroundValue == null || backgroundValue !in BACKGROUNDS_RANGE) {
            errors.add(BACKGROUND_ERROR_MESSAGE)
            false
        } else true
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        private const val TAG = "CreateCounterActivity lifecycle"
        val colors = listOf<String>("r", "g", "b", "m", "R", "G", "B", "M")
        private const val COUNTER_ERROR_MESSAGE = "Enter integer number in counter assignment"
        private const val COLOR_ERROR_MESSAGE = "Enter color symbol (r, b, g, m)"
        private const val BACKGROUND_ERROR_MESSAGE = "Unknown background"
        private val BACKGROUNDS_RANGE = 1..4
    }
}