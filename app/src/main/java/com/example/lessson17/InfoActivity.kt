package com.example.lessson17

import android.os.Build.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.lessson17.CreateCounterActivity.Companion.TAG
import java.text.SimpleDateFormat
import java.util.*

class InfoActivity : AppCompatActivity() {
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        Log.d(CreateCounterActivity.TAG, "InfoActivity onCreate")
        infoTextView = findViewById(R.id.infoScreen)
    }

    fun info(view: View) {
        when ((view as Button).text) {
            "device" -> {
                "$MANUFACTURER $MODEL".also { infoTextView.text = it }
            }
            "time" -> {
                infoTextView.text = SimpleDateFormat("HH:mm", Locale.US).format(Date())
            }
            "toast" -> {
                Toast.makeText(this, "Information", Toast.LENGTH_LONG).show()
            }
            else -> error("Unknown command")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "InfoActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "InfoActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "InfoActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "InfoActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "InfoActivity onDestroy")
    }
}