package com.example.lessson17

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SetCounterActivity : AppCompatActivity() {
    private lateinit var setCounterButton: Button
    private lateinit var counterSetText: EditText
    private lateinit var errorMessage: TextView
    private var error: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_counter)

        setCounterButton = findViewById(R.id.btn_set_counter)
        counterSetText = findViewById(R.id.set_counter_text)

        errorMessage = findViewById(R.id.counter_error_message)

        setCounterButton.setOnClickListener {
            checkCounterText()
            if (error == null) {
                val intent = Intent(this, CounterActivity::class.java)
                intent.putExtra(
                    CounterActivity.PARAM_COUNTER,
                    counterSetText.text.toString().toInt()
                )
                startActivity(intent)
            } else {
                errorMessage.text = error
                return@setOnClickListener
            }
        }
    }

    private fun checkCounterText(): Boolean {
        val counterValue = counterSetText.text.toString().toIntOrNull()
        return if (counterValue == null) {
            error = COUNTER_ERROR_MESSAGE
            false
        } else {
            error = null
            true
        }
    }

    companion object {
        private const val COUNTER_ERROR_MESSAGE = "Enter integer number in counter assignment"
    }
}