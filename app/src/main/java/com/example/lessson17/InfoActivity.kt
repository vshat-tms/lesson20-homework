package com.example.lessson17

import android.os.Build.MANUFACTURER
import android.os.Build.MODEL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        infoTextView = findViewById(R.id.text_info)
    }

    fun info(view: View) {
        when ((view as Button).text) {
            getString(R.string.device) -> {
                infoTextView.text = MANUFACTURER + " " + MODEL
            }
            getString(R.string.time) -> {
                infoTextView.text = SimpleDateFormat("HH:mm", Locale.US).format(Date())
            }
            getString(R.string.toast) -> {
                Toast.makeText(this, "hello", Toast.LENGTH_LONG).show()
            }
            else -> error("unknown command")
        }
    }

    companion object {
        private const val TAG = "lifecycle"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Info activity start")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Info activity pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Info activity stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Info activity destroy")
    }
}