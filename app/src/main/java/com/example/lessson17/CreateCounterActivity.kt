package com.example.lessson17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CreateCounterActivity : AppCompatActivity() {

    private lateinit var setNumber: EditText
    private lateinit var setColor: EditText
    private lateinit var setBackground: EditText
    private lateinit var createCounter: Button
    private lateinit var messageAboutError: TextView
    private var allErrors = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_counter)

        Log.d(TAG, "CreateCounterActivity onCreate")
        createCounter = findViewById(R.id.createCounterButton)
        createCounter.setOnClickListener {
            checkNumber()
            checkTextColor()
            checkNumberBackground()
            if (allErrors.isEmpty()) {
                val intent = Intent(this, CounterActivity::class.java)
                intent.putExtra(
                    CounterActivity.VALUE_COUNTER,
                    setNumber.text.toString().toInt()
                )
                intent.putExtra(
                    CounterActivity.VALUE_COLOR,
                    setColor.text.toString().lowercase()
                )
                intent.putExtra(
                    CounterActivity.VALUE_BACKGROUND,
                    setBackground.text.toString().toInt()
                )
                startActivity(intent)
            } else {
                val error = allErrors.toString()
                messageAboutError.text = error
                allErrors = mutableListOf()
                return@setOnClickListener
            }
        }
        setNumber = findViewById(R.id.counterSetNumber)
        setColor = findViewById(R.id.counterSetColor)
        setBackground = findViewById(R.id.counterSetBackground)
        messageAboutError = findViewById(R.id.ErrorScreen)
    }

    private fun checkNumber(): Boolean {
        val valueCounter = setNumber.text.toString().toIntOrNull()
        return if (valueCounter == null) {
            allErrors.add(NUMBER_MESSAGE_ERROR)
            false
        } else true
    }

    private fun checkTextColor(): Boolean {
        val colorSelected = setColor.text.toString()
        return if (!colors.contains(colorSelected)) {
            allErrors.add(COLOR_MESSAGE_ERROR)
            false
        } else true
    }

    private fun checkNumberBackground(): Boolean {
        val numberBackground = setBackground.text.toString().toIntOrNull()
        return if (numberBackground == null || numberBackground !in BACKGROUNDS_RANGE) {
            allErrors.add(BACKGROUND_MESSAGE_ERROR)
            false
        } else true
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "CreateCounterActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "CreateCounterActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "CreateCounterActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "CreateCounterActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "CreateCounterActivity onDestroy")
    }

    companion object {
        const val TAG = "Lifecycle"
        val colors = listOf("r", "g", "b", "m", "R", "G", "B", "M")
        private const val NUMBER_MESSAGE_ERROR = "Enter integer number in counter assignment"
        private const val COLOR_MESSAGE_ERROR = "Enter color symbol (r, b, g, m)"
        private const val BACKGROUND_MESSAGE_ERROR = "Unknown background"
        private val BACKGROUNDS_RANGE = 1..4
    }
}