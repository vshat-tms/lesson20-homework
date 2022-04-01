package com.example.lessson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class InfoActivity : AppCompatActivity() {

    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        infoTextView = findViewById(R.id.tv_info)
    }

    fun info(view: View) {
        when ((view as Button).text) {
            "device" -> {
                infoTextView.text = android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL

            }
            "time" -> {
                infoTextView.text = SimpleDateFormat("HH:mm", Locale.US).format(Date())
            }
            "toast" -> {
                Toast.makeText(this, "hello", Toast.LENGTH_LONG).show()
            }
            else -> error("unknown command")
        }
    }
}