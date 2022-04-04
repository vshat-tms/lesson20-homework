package com.example.lessson17

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CounterActivity : AppCompatActivity() {

    private var counter = 0
    private lateinit var valuesBackground: String

    private lateinit var background: View
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        infoTextView = findViewById(R.id.tv_info)
        background = findViewById(R.id.background)
        createCounter()

        findViewById<View>(R.id.btn_counter_minus).setOnClickListener {
            updateCounter(counter - COUNT_STEP)
        }
        findViewById<View>(R.id.btn_counter_plus).setOnClickListener {
            updateCounter(counter + COUNT_STEP)
        }
        findViewById<View>(R.id.btn_counter_rnd).setOnClickListener {
            updateCounter((MIN_VALUES_RANDOM..MAX_VALUES_RANDOM).random())
        }
        findViewById<View>(R.id.btn_counter_0).setOnClickListener {
            updateCounter(0)
        }

        val intentEditCounter = Intent(this, EditCounter::class.java)
        findViewById<Button>(R.id.btn_click_edit_counter).setOnClickListener {
            startActivity(intentEditCounter)
        }

        findViewById<Button>(R.id.btn_share).setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            val shareBody = counter.toString()
            share.type = "text/plain"
            share.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(share, shareBody))
        }

        Log.d(TAG, "Counter_Activity create")
    }

    fun setColorText(view: View) {
        setColor(((view as Button).text.toString()))
    }

    fun setBgClick(view: View) {
        setBg((view as Button).text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        updateCounter(savedInstanceState.getInt(COUNT_STATE))
        infoTextView.setTextColor(savedInstanceState.getInt(COLOR_STATE))
        valuesBackground = savedInstanceState.getString(BACKGROUND_STATE).toString()
        background.setBackgroundColor(Color.parseColor(valuesBackground))
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun updateCounter(value: Int) {
        counter = value
        infoTextView.text = value.toString()
    }

    private fun setBg(numberBackground: String) {
        val colorBackground = when (numberBackground) {
            getString(R.string.value_1) -> "#cccccc"
            getString(R.string.value_2) -> "#dddddd"
            getString(R.string.value_3) -> "#eeeeee"
            else -> "#ffffff"
        }
        val color = Color.parseColor(colorBackground)
        valuesBackground = colorBackground
        background.setBackgroundColor(color)
    }

    private fun setColor(color: String) {
        when (color) {
            "r" -> infoTextView.setTextColor(Color.RED)
            "g" -> infoTextView.setTextColor(Color.GREEN)
            "b" -> infoTextView.setTextColor(Color.BLUE)
            "m" -> infoTextView.setTextColor(Color.MAGENTA)
            else -> infoTextView.text = "unknown color"
        }
    }

    private fun createCounter() {
        intent.getStringExtra("valuesCounter")?.let { updateCounter(it.toInt()) }
        intent.getStringExtra("numberBackground")?.let { setBg(it) }
        intent.getStringExtra("valuesColor")?.let { setColor(it) }
    }

    companion object {
        private const val COUNT_STATE = "count"
        private const val COLOR_STATE = "color"
        private const val BACKGROUND_STATE = "background"
        private const val TAG = "lifecycle"
        private const val COUNT_STEP = 1
        private const val MAX_VALUES_RANDOM = 100
        private const val MIN_VALUES_RANDOM = -100
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNT_STATE, counter)
        outState.putInt(COLOR_STATE, infoTextView.currentTextColor)
        outState.putString(BACKGROUND_STATE, valuesBackground)
        super.onSaveInstanceState(outState)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Counter_Activity resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Counter_Activity pause")
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Counter_Activity stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Counter_Activity destroy")
    }

}
