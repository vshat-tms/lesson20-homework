package com.example.lessson17

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CounterActivity : AppCompatActivity() {
    var counter = 0

    private lateinit var infoTextView: TextView
    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        rootView = findViewById(R.id.root)
        infoTextView = findViewById(R.id.tv_info)

        findViewById<View>(R.id.btn_counter_minus).setOnClickListener {
            updateCounter(counter - 1)
        }
        findViewById<View>(R.id.btn_counter_plus).setOnClickListener {
            updateCounter(counter + 1)

        }
        findViewById<View>(R.id.btn_counter_rnd).setOnClickListener {
            updateCounter((-100..100).random())

        }
        findViewById<View>(R.id.btn_counter_0).setOnClickListener {
            updateCounter(0)
        }

        findViewById<View>(R.id.btn_color_r).setOnClickListener {
            infoTextView.setTextColor(Color.RED)
        }
        findViewById<View>(R.id.btn_color_g).setOnClickListener {
            infoTextView.setTextColor(Color.GREEN)
        }
        findViewById<View>(R.id.btn_color_b).setOnClickListener {
            infoTextView.setTextColor(Color.BLUE)
        }
        findViewById<View>(R.id.btn_color_m).setOnClickListener {
            infoTextView.setTextColor(Color.MAGENTA)

            Log.d(TAG, "CounterActivity создано")
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "CounterActivity onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "CounterActivity становиться видимым")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "CounterActivity получает фокус (состояние Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "CounterActivity приостановлено (состояние Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "CounterActivity остановлено (состояние Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "CounterActivity уничтожено")
    }

    private fun updateCounter(value: Int) {
        counter = value
        infoTextView.text = value.toString()
    }

    fun setBg(view: View) {
        val colorText = when ((view as Button).text) {
            "1" -> "#cccccc"
            "2" -> "#dddddd"
            "3" -> "#eeeeee"
            else -> "#ffffff"
        }
        val color = Color.parseColor(colorText)
        rootView.setBackgroundColor(color)
    }

    companion object {
        private const val TAG = "Lifecycle"
    }
}