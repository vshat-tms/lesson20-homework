package com.example.lessson17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CreateCounterActivity : AppCompatActivity() {

    private lateinit var createCounterButton: Button
    private lateinit var counterSetText: EditText
    private lateinit var textSetColor: EditText
    private lateinit var backgroundSetColor: EditText
    private lateinit var errorMessage: TextView
    private var errors = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_counter)

        createCounterButton = findViewById(R.id.createCounterButtonInActivity)
        counterSetText = findViewById(R.id.counter_set_text)
        textSetColor = findViewById(R.id.color_set_text)
        backgroundSetColor = findViewById(R.id.background_set_text)
        errorMessage = findViewById(R.id.counter_create_error_message)
        createCounterButton.setOnClickListener {
            generalCrateCounterCheck()
            if (errors.isEmpty()) {
                val intent = Intent(this, CounterActivity::class.java)
                intent.putExtra(
                    CounterActivity.PARAM_COUNTER,
                    counterSetText.text.toString().toInt()
                )
                intent.putExtra(
                    CounterActivity.PARAM_COLOR,
                    textSetColor.text.toString().lowercase()
                )
                intent.putExtra(
                    CounterActivity.PARAM_BACKGROUND,
                    backgroundSetColor.text.toString()
                )
                startActivity(intent)
            } else {
                val error = errors.toString()
                errorMessage.text = error
                errors = mutableListOf()
                return@setOnClickListener
            }
        }
    }

    private fun generalCrateCounterCheck() {
        checkCounterFieldText()
        checkTextColorFieldText()
        checkBackgroundColorFieldText()
    }

    private fun checkCounterFieldText(): Boolean {
        val counterFieldValue = counterSetText.text.toString().toIntOrNull()
        return if (counterFieldValue == null) {
            errors.add(COUNTER_FIELD_ERROR_MESSAGE)
            false
        } else true
    }

    private fun checkTextColorFieldText(): Boolean {
        val colorField = textSetColor.text.toString()
        return if (!colors.contains(colorField)) {
            errors.add(TEXT_COLOR_FIELD_MESSAGE)
        } else true
    }

    private fun checkBackgroundColorFieldText(): Boolean {
        val backgroundColorField = backgroundSetColor.text.toString().toIntOrNull()
        return if (backgroundColorField == null || backgroundColorField !in BACKGROUND_COLOR_FIELD_RANGE) {
            errors.add(BACKGROUND_COLOR_FIELD_MESSAGE)
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
        private const val COUNTER_FIELD_ERROR_MESSAGE =
            "Enter integer number in Counter value field"
        private const val TEXT_COLOR_FIELD_MESSAGE = "Enter correct symbol - r, b, g, m"
        private const val BACKGROUND_COLOR_FIELD_MESSAGE =
            "Enter integer from 1 to 4 in Background color field"
        private val BACKGROUND_COLOR_FIELD_RANGE = 1..4
        val colors = listOf("r", "g", "b", "m", "R", "G", "B", "M")
    }
}