package com.example.lessson17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.lessson17.CreateCounterActivity.Companion.TAG

class EditCounterActivity : AppCompatActivity() {
    private lateinit var setNumber: EditText
    private lateinit var createCounter: Button
    private lateinit var messageAboutError: TextView
    private var allErrors = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_counter)
        createCounter = findViewById(R.id.createCounterButton)
        setNumber = findViewById(R.id.editSetNumber)
        messageAboutError = findViewById(R.id.ErrorScreen)

        createCounter.setOnClickListener {
            checkNumber()
            if (allErrors.isEmpty()) {
                val intent = Intent(this, CounterActivity::class.java)
                intent.putExtra(
                    CounterActivity.VALUE_COUNTER,
                    setNumber.text.toString().toInt()
                )
                startActivity(intent)
            } else {
                val error = allErrors.toString()
                messageAboutError.text = error
                allErrors = mutableListOf()
                return@setOnClickListener
            }
        }
    }

    private fun checkNumber(): Boolean {
        val valueCounter = setNumber.text.toString().toIntOrNull()
        return if (valueCounter == null) {
            allErrors.add(NUMBER_MESSAGE_ERROR)
            false
        } else true
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "EditCounterActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "EditCounterActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "EditCounterActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "EditCounterActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "EditCounterActivity onDestroy")
    }

    companion object {
        private const val NUMBER_MESSAGE_ERROR = "Enter integer number in counter assignment"
    }
}