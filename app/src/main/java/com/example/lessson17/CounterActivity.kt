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
    private var counter = COUNTER_START_VALUE
    private lateinit var infoTextView: TextView
    private lateinit var rootView: View
    private lateinit var redColorButton: Button
    private lateinit var blueColorButton: Button
    private lateinit var greenColorButton: Button
    private lateinit var magentaColorButton: Button
    private lateinit var setCounterButton: Button
    private lateinit var shareCounterButton: Button
    private var currentBackgroundColor: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        Log.d(TAG, "onCreate")
        rootView = findViewById(R.id.counter_root)
        infoTextView = findViewById(R.id.counter_activity_tv_info)
        redColorButton = findViewById(R.id.btn_color_r)
        blueColorButton = findViewById(R.id.btn_color_b)
        greenColorButton = findViewById(R.id.btn_color_g)
        magentaColorButton = findViewById(R.id.btn_color_m)
        setCounterButton = findViewById(R.id.btn_edit_counter)
        shareCounterButton = findViewById(R.id.btn_share_counter)

        updateCounter(intent.getIntExtra(PARAM_COUNTER, 0))
        intent.getStringExtra(PARAM_COLOR)?.let { setTextColor(it) }
        intent.getStringExtra(PARAM_BACKGROUND)?.let { setBg(it) }

        findViewById<View>(R.id.btn_counter_minus).setOnClickListener {
            updateCounter(counter - COUNTER_STEP)
        }
        findViewById<View>(R.id.btn_counter_plus).setOnClickListener {
            updateCounter(counter + COUNTER_STEP)
        }
        findViewById<View>(R.id.btn_counter_rnd).setOnClickListener {
            updateCounter((COUNTER_RANDOM_MIN_VALUE..COUNTER_RANDOM_MAX_VALUE).random())
        }
        findViewById<View>(R.id.btn_counter_0).setOnClickListener {
            updateCounter(COUNTER_START_VALUE)
        }

        setCounterButton.setOnClickListener {
            val intent = Intent(this, SetCounterActivity::class.java)
            startActivity(intent)
        }

        if (savedInstanceState != null) {
            updateCounter(savedInstanceState.getInt(PARAM_COUNTER))
            infoTextView.setTextColor(savedInstanceState.getInt(PARAM_COLOR))
            savedInstanceState.getString(PARAM_BACKGROUND)?.let { setBg(it) }
        }

        shareCounterButton.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            val shareBody = counter.toString()
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(intent, shareBody))
        }
    }

    fun onColorTextButtonClick(view: View) {
        setTextColor((view as Button).text.toString())
    }

    private fun setTextColor(color: String) {
        when (color) {
            COLOR_RED_SIGNATURE -> infoTextView.setTextColor(Color.RED)
            COLOR_GREEN_SIGNATURE -> infoTextView.setTextColor(Color.GREEN)
            COLOR_BLUE_SIGNATURE -> infoTextView.setTextColor(Color.BLUE)
            COLOR_MAGENTA_SIGNATURE -> infoTextView.setTextColor(Color.MAGENTA)
            else -> infoTextView.setTextColor(Color.BLACK)
        }
    }

    fun onBackgroundTextButtonClick(view: View) {
        setBg((view as Button).text.toString())
    }

    private fun setBg(backgroundColorNumber: String) {
        val colorText = when (backgroundColorNumber) {
            BACKGROUND_SIGNATURE_1 -> BACKGROUND_COLOR_1
            BACKGROUND_SIGNATURE_2 -> BACKGROUND_COLOR_2
            BACKGROUND_SIGNATURE_3 -> BACKGROUND_COLOR_3
            else -> BACKGROUND_COLOR_4
        }
        val color = Color.parseColor(colorText)
        rootView.setBackgroundColor(color)
        currentBackgroundColor = backgroundColorNumber
    }

    private fun updateCounter(value: Int) {
        counter = value
        infoTextView.text = value.toString()
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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(PARAM_COUNTER, counter)
        outState.putInt(PARAM_COLOR, infoTextView.currentTextColor)
        outState.putString(PARAM_BACKGROUND, currentBackgroundColor)
        super.onSaveInstanceState(outState)
    }

    companion object {
        private const val TAG = "CounterActivity lifecycle"
        const val PARAM_COUNTER = "counter"
        const val PARAM_COLOR = "color"
        const val PARAM_BACKGROUND = "background"
        private const val COUNTER_STEP = 1
        private const val COUNTER_START_VALUE = 0
        private const val COUNTER_RANDOM_MIN_VALUE = -100
        private const val COUNTER_RANDOM_MAX_VALUE = 100
        private const val COLOR_RED_SIGNATURE = "r"
        private const val COLOR_BLUE_SIGNATURE = "b"
        private const val COLOR_GREEN_SIGNATURE = "g"
        private const val COLOR_MAGENTA_SIGNATURE = "m"
        private const val BACKGROUND_COLOR_1 = "#cccccc"
        private const val BACKGROUND_COLOR_2 = "#dddddd"
        private const val BACKGROUND_COLOR_3 = "#eeeeee"
        private const val BACKGROUND_COLOR_4 = "#ffffff"
        private const val BACKGROUND_SIGNATURE_1 = "1"
        private const val BACKGROUND_SIGNATURE_2 = "2"
        private const val BACKGROUND_SIGNATURE_3 = "3"
    }
}