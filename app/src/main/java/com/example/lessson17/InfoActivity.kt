package com.example.lessson17

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class InfoActivity : AppCompatActivity() {
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        Log.d(TAG, "onCreate")

        infoTextView = findViewById(R.id.info_activity_tv_info)
    }

    fun info(view: View) {
        when ((view as Button).text) {
            getString(R.string.btn_device) -> {
                infoTextView.text = android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL

            }
            getString(R.string.btn_time) -> {
                infoTextView.text = SimpleDateFormat("HH:mm", Locale.US).format(Date())
            }
            getString(R.string.btn_toast) -> {
                Toast.makeText(this, "hello", Toast.LENGTH_LONG).show()
            }
            else -> error(ERROR_MESSAGE)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        private const val TAG = "InfoActivity lifecycle"
        private const val ERROR_MESSAGE = "unknown command"
    }
}