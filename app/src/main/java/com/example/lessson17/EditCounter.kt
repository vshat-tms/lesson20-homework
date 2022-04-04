package com.example.lessson17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EditCounter : AppCompatActivity() {

    private lateinit var buttonSet: Button
    private lateinit var editValuesCounter: EditText
    private lateinit var errorText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_counter)

        buttonSet = findViewById(R.id.edit_button_create)
        editValuesCounter = findViewById(R.id.edit_counter_value)
        errorText = findViewById(R.id.edit_text_error)

        buttonSet.setOnClickListener {
            editCounter()
        }
        Log.d(TAG, "Edit Counter create")
    }

    private fun editCounter() {
        val intent = Intent(this, CounterActivity::class.java)

        if (!checkValuesCounter()) {
            intent.putExtra("valuesCounter", editValuesCounter.text.toString())
            startActivity(intent)
        } else {
            editValuesCounter.text.clear()
            errorText.text = "ERROR values counter integer"
        }
    }

    private fun checkValuesCounter(): Boolean {
        val values = editValuesCounter.text.toString().toIntOrNull()
        return (editValuesCounter.text.toString().isEmpty() || values == null)
    }

    companion object {
        private const val TAG = "lifecycle"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Edit Counter start")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Edit Counter pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Edit Counter stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Edit Counter destroy")
    }
}