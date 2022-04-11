package com.example.lessson17

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditCounter : AppCompatActivity() {

    private lateinit var setButton: Button
    private lateinit var editValueCounter: EditText
    private lateinit var errorText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_counter)

        setButton = findViewById(R.id.set_button)
        editValueCounter = findViewById(R.id.edit_counter_editText)
        errorText = findViewById(R.id.error_textView)

        setButton.setOnClickListener {
            editCounter()
        }
        Log.d(TAG, "EditCounter onResume")
    }

    private fun editCounter() {
        val intent = Intent()
        var counterValues = 0
        try {
            counterValues = editValueCounter.text.toString().toInt()
        } catch (e: NumberFormatException) {
            errorText.text = getString(R.string.error_textView_editCounter)
            return
        }
        intent.putExtra(CounterActivity.COUNT_STATE, counterValues)
        setResult(RESULT_OK, intent)
        finish()
    }

//    private fun editCounter() {
//        val intent = Intent(this, CounterActivity::class.java)
//
//        if (!checkCounterValues()) {
//            intent.putExtra("valueCounter", editValueCounter.text.toString())
//            startActivity(intent)
//        } else {
//            editValueCounter.text.clear()
//            errorText.text = getString(R.string.error_textView_editCounter)
//        }
//    }
//
//    private fun checkCounterValues(): Boolean {
//        val values = editValueCounter.text.toString().toIntOrNull()
//        return (editValueCounter.toString().isEmpty() || values == null)
//    }

    companion object {
        private const val TAG = "EditCounter"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "EditCounter onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "EditCounter onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "EditCounter onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "EditCounter onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "EditCounter onDestroy")

    }

}