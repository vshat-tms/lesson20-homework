package com.example.lessson17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EditCounterActivity : AppCompatActivity() {

    private lateinit var setCounterButton: Button
    private lateinit var counterSetText: EditText
    private lateinit var errorMessage: TextView
    private var error: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_counter)

        setCounterButton = findViewById(R.id.setCounterValueButton)
        counterSetText = findViewById(R.id.setCounterValueField)
        errorMessage = findViewById(R.id.counterErrorMessageField)

        setCounterButton.setOnClickListener {
            checkCounterSetFieldValue()
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

    private fun checkCounterSetFieldValue(): Boolean {
        val fieldValue = counterSetText.text.toString().toIntOrNull()
        return if (fieldValue == null) {
            error = COUNTER_ERROR_MESSAGE
            false
        } else {
            error = null
            true
        }
    }

    companion object {
        private const val COUNTER_ERROR_MESSAGE = "Enter integer number in field"
    }
}