package com.example.lessson17

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreateCounterActivity : AppCompatActivity() {

    private lateinit var editCounterValues: EditText
    private lateinit var editCounterColor: EditText
    private lateinit var editCounterBackground: EditText
    private lateinit var errorText: TextView
    private lateinit var createButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_counter)

        editCounterValues = findViewById(R.id.edit_number)
        editCounterColor = findViewById(R.id.edit_color)
        editCounterBackground = findViewById(R.id.edit_background)
        errorText = findViewById(R.id.error_text)
        createButton = findViewById(R.id.create_btn)

        createButton.setOnClickListener {
            errorText.text = BLANK
            createCounter()
        }
    }

    private fun createCounter() {
        val intent = Intent(this, CounterActivity::class.java)

        val one = checkCounterColor()
        val two = checkCounterValues()
        val three = checkCounterBackground()
        Log.d(TAG, "color $one")
        Log.d(TAG, "counter $two")
        Log.d(TAG, "background $three")

        if (!checkCounterValues()) {
            intent.putExtra("counterValues", editCounterValues.text.toString())
        } else {
            editCounterValues.text.clear()
            errorText.text = getString(R.string.error_textView_counter_values)
        }

        if (checkCounterColor()) {
            intent.putExtra("counterColor", editCounterColor.text.toString())
        } else {
            editCounterColor.text.clear()
            errorText.text =
                "${errorText.text}\n" + getString(R.string.error_textView_counter_color)
        }

        if (checkCounterBackground()) {
            intent.putExtra("counterBackground", editCounterBackground.text.toString())
        } else {
            editCounterBackground.text.clear()
            errorText.text =
                "${errorText.text}\n" + getString(R.string.error_textView_counter_background)
        }

        if (errorText.text == BLANK) {
            startActivity(intent)
        } else {
            errorText.text = "${errorText.text}\n" + getString(R.string.error_textView_repeat)
        }

    }

    private fun checkCounterValues(): Boolean {
        val values = editCounterValues.text.toString().toIntOrNull()
        Log.d(TAG, "значение счётчика = $values")
        return (editCounterValues.toString().isEmpty() || values == null)
    }

    private fun checkCounterColor(): Boolean {
        Log.d(TAG, "цвет счётчика = ${editCounterColor.text}")
        return when (editCounterColor.text.toString().lowercase()) {
            "r" -> true
            "g" -> true
            "b" -> true
            "m" -> true
            else -> false
        }
    }

    private fun checkCounterBackground(): Boolean {
        val background = editCounterBackground.text.toString().toIntOrNull()
        Log.d(TAG, "цвет фона = $background")
        return (editCounterBackground.text.isNotEmpty() || background in 1..4)
    }

    companion object {
        private const val TAG = "CreateCounterActivity"
        private const val BLANK = ""
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Create Counter start")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Create Counter pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Create Counter stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Create Counter destroy")
    }
}