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
    private lateinit var infoTextView: TextView
    private lateinit var rootView: View
    private var valuesBackground: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        infoTextView = findViewById(R.id.tv_info)
        rootView = findViewById(R.id.root)
        createCounter()

        findViewById<View>(R.id.btn_counter_minus).setOnClickListener {
            updateCounter(counter - COUNTER_CHANGE)
        }
        findViewById<View>(R.id.btn_counter_plus).setOnClickListener {
            updateCounter(counter + COUNTER_CHANGE)
        }
        findViewById<View>(R.id.btn_counter_rnd).setOnClickListener {
            updateCounter((MIN_RND..MAX_RND).random())
        }
        findViewById<View>(R.id.btn_counter_0).setOnClickListener {
            updateCounter(0)
        }
        findViewById<Button>(R.id.edit_counter).setOnClickListener {
            val intent = Intent(this, EditCounter::class.java)
            startActivityForResult(intent, 1)
        }
        findViewById<Button>(R.id.share).setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val shareCounter = counter.toString()
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, shareCounter)
            startActivity(Intent.createChooser(intent, shareCounter))
        }
//        val intentEditCounter = Intent(this, EditCounter::class.java)
//        findViewById<Button>(R.id.edit_counter).setOnClickListener {
//            startActivity(intentEditCounter)
//        }
//        if (savedInstanceState != null) {
//            updateCounter(savedInstanceState.getInt(COUNT_STATE))
//            infoTextView.setTextColor(savedInstanceState.getInt(COUNT_STATE))
//            savedInstanceState.getString(COUNT_STATE)?.let { setBg(it) }
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            return
        }
        updateCounter(data.getIntExtra(COUNT_STATE, 0))
    }

    fun setColorOnclick(view: View) {
        setColor((view as Button).text.toString())
    }

    fun setBackgroundOnclick(view: View) {
        setBg((view as Button).text.toString())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNT_STATE, counter)
        outState.putInt(COLOR_STATE, infoTextView.currentTextColor)
        outState.putString(BACKGROUND_STATE, valuesBackground)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        updateCounter(savedInstanceState.getInt(COUNT_STATE))
        infoTextView.setTextColor(savedInstanceState.getInt(COLOR_STATE))
        savedInstanceState.getString(BACKGROUND_STATE)?.let { setBg(it) }
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun updateCounter(value: Int) {
        counter = value
        infoTextView.text = value.toString()
    }

    private fun setBg(numberBackground: String?) {
        val colorBackground = when ((numberBackground)) {
            getString(R.string.background_value_1) -> "#FF3700B3"
            getString(R.string.background_value_2) -> "#FFAB00"
            getString(R.string.background_value_3) -> "#FF03DAC5"
            else -> "#FFFFFF"
        }
        val color = Color.parseColor(colorBackground)
        valuesBackground = colorBackground
        rootView.setBackgroundColor(color)
    }

    private fun setColor(color: String) {
        when (color) {
            getString(R.string.color_text_red) -> infoTextView.setTextColor(Color.RED)
            getString(R.string.color_text_green) -> infoTextView.setTextColor(Color.GREEN)
            getString(R.string.color_text_blue) -> infoTextView.setTextColor(Color.BLUE)
            getString(R.string.color_text_magenta) -> infoTextView.setTextColor(Color.MAGENTA)
            else -> infoTextView.text = MESSAGE_COLOR
        }
    }

    private fun createCounter() {
        intent.getStringExtra("counterValues")?.let { updateCounter(it.toInt()) }
        intent.getStringExtra("counterBackground")?.let { setBg(it) }
        intent.getStringExtra("counterColor")?.let { setColor(it) }
    }

    companion object {
        private const val MIN_RND = -100
        private const val MAX_RND = 100
        private const val COUNTER_CHANGE = 1
        private const val MESSAGE_COLOR = "Enter the correct color"
        private const val COLOR_STATE = "color"
        private const val BACKGROUND_STATE = "background"
        private const val TAG = "CounterActivity"
        const val COUNT_STATE = "count"
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

}
