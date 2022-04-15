package com.example.lessson17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class EditCounterActivity : AppCompatActivity() {
    private lateinit var textNewCountry: TextView
    private lateinit var error: TextView

    private var newValueCountry: Int?
        get() = textNewCountry.text.toString().toIntOrNull()
        set(value) {
            textNewCountry.text = value.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_counter)

        textNewCountry = findViewById(R.id.new_value_country)
        error = findViewById(R.id.error_edit_counter)
    }

    fun btnAsk(view: View) {
        val intentNewCountry = Intent()
        intentNewCountry.putExtra("newValueCountry", newValueCountry)
        if (newValueCountry is Int) {
            setResult(RESULT_OK, intentNewCountry)
            finish()
        } else {
            error.text = "ERROR..\n Enter correct data."
        }
    }
}