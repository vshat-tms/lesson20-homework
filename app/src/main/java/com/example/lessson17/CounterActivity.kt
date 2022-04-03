package com.example.lessson17

import android.app.Notification
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class CounterActivity : AppCompatActivity() {

    private lateinit var tvInfo: TextView
    private lateinit var activityCounter: View
    private var counter = 0
    private var bgColor: Int = 0
    private var textColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        val counterValue = intent.getIntExtra(CreateCounterActivity.COUNTER_VALUE_KEY, 0)
        val savedCounter = savedInstanceState?.getInt(COUNTER)
        val savedTextColor = savedInstanceState?.getInt(TEXT_COLOR)
        val savedBgColor = savedInstanceState?.getInt(BG_COLOR)

        activityCounter = findViewById(R.id.counter_activity)
        tvInfo = findViewById(R.id.tv_info)
        bgColor = intent.getIntExtra(CreateCounterActivity.BG_COLOR_VALUE_KEY, 0)
        textColor = intent.getIntExtra(CreateCounterActivity.TEXT_COLOR_VALUE_KEY, 0)


        if (bgColor != 0 && textColor != 0) {
            activityCounter.setBackgroundColor(resources.getColor(bgColor))
            tvInfo.setTextColor(resources.getColor(textColor))
            tvInfo.text = counterValue.toString()
            updateCounter(counterValue)
        }

        if (savedCounter != null) {
            updateCounter(savedCounter)
        }

        if (savedBgColor != null && savedBgColor != 0) {
            activityCounter.setBackgroundColor(resources.getColor(savedBgColor))
            bgColor = savedBgColor
        }

        if (savedTextColor != null && savedTextColor != 0) {
            tvInfo.setTextColor(resources.getColor(savedTextColor))
            textColor = savedTextColor
        }

        findViewById<Button>(R.id.edit_btn).setOnClickListener {
            val intent = Intent(this, EditCounter::class.java)
            startActivityForResult(intent, 1)
        }

        findViewById<Button>(R.id.share_btn).setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val shareCounter = counter.toString()
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,shareCounter)
            startActivity(Intent.createChooser(intent, shareCounter))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data == null) {
            return
        }
        updateCounter(data.getIntExtra(COUNTER, 0))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER, counter)
        outState.putInt(TEXT_COLOR, textColor)
        outState.putInt(BG_COLOR, bgColor)
    }

    fun setBg(view: View) {
        bgColor = when ((view as Button).text) {
            "1" -> R.color.bg_light_blue
            "2" -> R.color.bg_light_green
            "3" -> R.color.bg_light_pink
            else -> R.color.bg_orange
        }

        activityCounter.setBackgroundColor(resources.getColor(bgColor))
    }

    fun setTextColor(view: View) {
        textColor = when ((view as Button).text) {
            "r" -> R.color.text_red
            "b" -> R.color.text_blue
            "g" -> R.color.text_green
            else -> R.color.text_magenta
        }

        tvInfo.setTextColor(resources.getColor(textColor))
    }

    fun setCounter(view: View) {
        when ((view as Button).text) {
            "+" -> updateCounter(counter + 1)
            "-" -> updateCounter(counter - 1)
            "0" -> updateCounter(0)
            else -> {
                updateCounter((MIN_RND_VALUE..MAX_RND_VALUE).random())
            }
        }
    }

    private fun updateCounter(value: Int) {
        counter = value
        tvInfo.text = value.toString()
    }

    companion object {
        const val MIN_RND_VALUE = 0
        const val MAX_RND_VALUE = 1000

        const val TEXT_COLOR = "TEXT_COLOR"
        const val BG_COLOR = "BG_COLOR"
        const val COUNTER = "COUNTER"
    }

}