package com.example.lessson17

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class CounterActivity : AppCompatActivity() {

    private var counter = DEFAULT_COUNTER_VALUE
    private var currentBackgroundColor: String? = null

    private lateinit var rootView: View
    private lateinit var infoTextView: TextView
    private lateinit var redTextColorButton: Button
    private lateinit var greenTextColorButton: Button
    private lateinit var blueTextColorButton: Button
    private lateinit var magentaTextColorButton: Button
    private lateinit var editCounterButton: Button
    private lateinit var shareCounterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        Log.d(TAG, "onCreate")

        rootView = findViewById(R.id.counter_root)
        infoTextView = findViewById(R.id.counter_activity_tv_info)
        redTextColorButton = findViewById(R.id.btn_color_r)
        greenTextColorButton = findViewById(R.id.btn_color_g)
        blueTextColorButton = findViewById(R.id.btn_color_b)
        magentaTextColorButton = findViewById(R.id.btn_color_m)
        editCounterButton = findViewById(R.id.editCounterButton)
        shareCounterButton = findViewById(R.id.shareCounterButton)

        updateCounter(intent.getIntExtra(PARAM_COUNTER, 0))
        intent.getStringExtra(PARAM_BACKGROUND)?.let { setBg(it) }
        intent.getStringExtra(PARAM_COLOR)?.let { setTextColor(it) }

        findViewById<View>(R.id.btn_counter_minus).setOnClickListener {
            updateCounter(counter - COUNTER_STEP)
        }

        findViewById<View>(R.id.btn_counter_plus).setOnClickListener {
            updateCounter(counter + COUNTER_STEP)
        }

        findViewById<View>(R.id.btn_counter_0).setOnClickListener {
            updateCounter(DEFAULT_COUNTER_VALUE)
        }

        findViewById<View>(R.id.btn_counter_rnd).setOnClickListener {
            val randomRange =
                resources.getInteger(R.integer.min_random_counter_value)..resources.getInteger(R.integer.max_random_counter_value)
            updateCounter(randomRange.random())
        }

        editCounterButton.setOnClickListener {
            val intent = Intent(this, EditCounterActivity::class.java)
            startActivity(intent)
        }

        if (savedInstanceState != null) {
            updateCounter(savedInstanceState.getInt(PARAM_COUNTER))
            infoTextView.setTextColor(savedInstanceState.getInt(PARAM_COLOR))
            savedInstanceState.getString(PARAM_BACKGROUND)?.let { setBg(it) }
        }

        shareCounterButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val toShare = counter.toString()
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, toShare)
            startActivity(Intent.createChooser(intent, toShare))
        }
    }

    private fun updateCounter(value: Int) {
        counter = value
        infoTextView.text = value.toString()
    }

    fun onColorTextButtonClick(view: View) {
        setTextColor((view as Button).text.toString())
    }

    private fun setTextColor(color: String) {
        when (color) {
            getString(R.string.r_symbol) -> infoTextView.setTextColor(Color.RED)
            getString(R.string.g_symbol) -> infoTextView.setTextColor(Color.GREEN)
            getString(R.string.b_symbol) -> infoTextView.setTextColor(Color.BLUE)
            getString(R.string.m_symbol) -> infoTextView.setTextColor(Color.MAGENTA)
        }
    }

    fun onBackgroundTextButtonClick(view: View) {
        setBg((view as Button).text.toString())
    }

    private fun setBg(backgroundColorNumber: String) {
        val colorText = when (backgroundColorNumber) {
            getString(R.string.number_1) -> getColor(R.color.background_gray)
            getString(R.string.number_2) -> getColor(R.color.background_light_gray)
            getString(R.string.number_3) -> getColor(R.color.background_ivory)
            else -> getColor(R.color.black)
        }
        rootView.setBackgroundColor(colorText)
        currentBackgroundColor = backgroundColorNumber
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
        const val PARAM_COUNTER = "counter"
        const val PARAM_COLOR = "color"
        const val PARAM_BACKGROUND = "background"
        private const val TAG = "CounterActivity info: "
        private const val COUNTER_STEP = 1
        private const val DEFAULT_COUNTER_VALUE = 0
    }
}