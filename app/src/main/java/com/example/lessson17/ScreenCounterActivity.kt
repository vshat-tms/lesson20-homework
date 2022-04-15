package com.example.lessson17

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class ScreenCounterActivity : AppCompatActivity() {

    private lateinit var valueScreenCounter: TextView
    private lateinit var colorBackground: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_counter)

        valueScreenCounter = findViewById(R.id.valueScreenCounter)
        colorBackground = findViewById(R.id.root)

        valueScreen()
        colorTextScreen()
        colorBackgroundScreen()

        Log.d(TAG, "ScreenCounterActivity создано")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "ScreenCounterActivity onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ScreenCounterActivity становиться видимым")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ScreenCounterActivity получает фокус (состояние Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "ScreenCounterActivity приостановлено (состояние Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ScreenCounterActivity остановлено (состояние Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ScreenCounterActivity уничтожено")
    }

    fun valueScreen() {
        val intentValue = Intent(intent)
        val value = intentValue.getIntExtra("valueCountry", 0)
        valueScreenCounter.text = value.toString()
    }

    fun colorTextScreen() {
        val intentColorText = Intent(intent)
        val colorText = when (intentColorText.getStringExtra("colorText")) {
            "r" -> valueScreenCounter.setTextColor(Color.RED)
            "g" -> valueScreenCounter.setTextColor(Color.GREEN)
            "b" -> valueScreenCounter.setTextColor(Color.BLUE)
            else -> valueScreenCounter.setTextColor(Color.MAGENTA)
        }
    }

    fun colorBackgroundScreen() {
        val intentColorBackground = Intent(intent)
        val colorBack = when (intentColorBackground.getStringExtra("colorBackground")) {
            "1" -> colorBackground.setBackgroundColor(Color.GRAY)
            "2" -> colorBackground.setBackgroundColor(Color.YELLOW)
            "3" -> colorBackground.setBackgroundColor(Color.BLACK)
            else -> colorBackground.setBackgroundColor(Color.DKGRAY)
        }
    }

    fun btnEdit(view: View) {
        val intentEditCounter = Intent(this, EditCounterActivity::class.java)
        startActivityForResult(intentEditCounter, 1)
    }

    fun btnShare(view: View) {
        val intentSend = Intent()
        intentSend.action = Intent.ACTION_SEND
        intentSend.putExtra(Intent.EXTRA_TEXT, valueScreenCounter.text)
        intentSend.type = "text/plain"

        val intentShare = Intent.createChooser(intentSend, null)
        startActivity(intentShare)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            return
        } else {
            var count = data.getIntExtra("newValueCountry", 0)
            valueScreenCounter.text = count.toString()
        }
    }

    companion object {
        private const val TAG = "Lifecycle"
    }
}