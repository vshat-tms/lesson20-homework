package com.example.lessson17

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lessson17.CreateCounterActivity.Companion.TAG

class CounterActivity : AppCompatActivity() {
    private lateinit var infoTextView: TextView
    private lateinit var rootView: View
    private lateinit var editCounter: Button
    private lateinit var shareAction: Button
    private var counter = COUNTER_START_VALUE
    private var currentColorBackground: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        rootView = findViewById(R.id.root)
        infoTextView = findViewById(R.id.counterScreen)
        editCounter = findViewById(R.id.editCounterButton)
        shareAction = findViewById(R.id.shareButton)

        Log.d(TAG, "CounterActivity onCreate")

        if (savedInstanceState != null) {
            updateCounter(savedInstanceState.getInt(VALUE_COUNTER))
            infoTextView.setTextColor(savedInstanceState.getInt(VALUE_COLOR))
            savedInstanceState.getString(VALUE_BACKGROUND)?.let { setBg(it) }
        }

        updateCounter(intent.getIntExtra(VALUE_COUNTER, 0))
        intent.getStringExtra(VALUE_COLOR)?.let { setTextColor(it) }
        intent.getStringExtra(VALUE_BACKGROUND)?.let { setBg(it) }

        editCounter.setOnClickListener {
            val intentEdit = Intent(this, EditCounterActivity::class.java)
            startActivity(intentEdit)
        }

        shareAction.setOnClickListener {
            val intentShare = Intent(Intent.ACTION_SEND)
            intentShare.type = "text/plain"
            intentShare.putExtra(
                Intent.EXTRA_SUBJECT,
                infoTextView.text
            )
            startActivity(Intent.createChooser(intentShare, infoTextView.text))
        }

        findViewById<View>(R.id.buttonCounterMinus).setOnClickListener {
            updateCounter(counter - COUNTER_STEP)
        }

        findViewById<View>(R.id.buttonCounterPlus).setOnClickListener {
            updateCounter(counter + COUNTER_STEP)
        }

        findViewById<View>(R.id.buttonCounterRandom).setOnClickListener {
            updateCounter((COUNTER_RANDOM_MIN_VALUE..COUNTER_RANDOM_MAX_VALUE).random())
        }

        findViewById<View>(R.id.buttonCounterZero).setOnClickListener {
            updateCounter(COUNTER_START_VALUE)
        }

        findViewById<View>(R.id.buttonColorLetter_r).setOnClickListener {
            infoTextView.setTextColor(Color.RED)
        }

        findViewById<View>(R.id.buttonColorLetter_g).setOnClickListener {
            infoTextView.setTextColor(Color.GREEN)
        }

        findViewById<View>(R.id.buttonColorLetter_b).setOnClickListener {
            infoTextView.setTextColor(Color.BLUE)
        }

        findViewById<View>(R.id.buttonColorLetter_m).setOnClickListener {
            infoTextView.setTextColor(Color.MAGENTA)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "CounterActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "CounterActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "CounterActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "CounterActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "CounterActivity onDestroy")
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
        currentColorBackground = backgroundColorNumber
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

    private fun updateCounter(value: Int) {
        counter = value
        infoTextView.text = value.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(VALUE_COUNTER, counter)
        outState.putInt(VALUE_COLOR, infoTextView.currentTextColor)
        outState.putString(VALUE_BACKGROUND, currentColorBackground)
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val VALUE_COUNTER = "counter"
        const val VALUE_COLOR = "color"
        const val VALUE_BACKGROUND = "background"
        private const val BACKGROUND_COLOR_1 = "#cccccc"
        private const val BACKGROUND_COLOR_2 = "#dddddd"
        private const val BACKGROUND_COLOR_3 = "#eeeeee"
        private const val BACKGROUND_COLOR_4 = "#ffffff"
        private const val BACKGROUND_SIGNATURE_1 = "1"
        private const val BACKGROUND_SIGNATURE_2 = "2"
        private const val BACKGROUND_SIGNATURE_3 = "3"
        private const val COLOR_RED_SIGNATURE = "r"
        private const val COLOR_BLUE_SIGNATURE = "b"
        private const val COLOR_GREEN_SIGNATURE = "g"
        private const val COLOR_MAGENTA_SIGNATURE = "m"
        private const val COUNTER_STEP = 1
        private const val COUNTER_START_VALUE = 0
        private const val COUNTER_RANDOM_MIN_VALUE = -100
        private const val COUNTER_RANDOM_MAX_VALUE = 100
    }
}