package com.example.lessson17

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

        infoTextView = findViewById(R.id.tv_info)

        Log.d(TAG, "InfoActivity создано")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "InfoActivity onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "InfoActivity становиться видимым")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "InfoActivity получает фокус (состояние Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "InfoActivity приостановлено (состояние Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "InfoActivity остановлено (состояние Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "InfoActivity уничтожено")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(INFO_KEY, infoTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        infoTextView.text = savedInstanceState.getString(INFO_KEY)
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

    companion object {
        private const val INFO_KEY = "info"

        private const val TAG = "Lifecycle"
    }
}