package com.example.lessson17

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class CreateCounterActivity : AppCompatActivity() {

    private lateinit var editCounterValue: EditText
    private lateinit var editTextColorValue: EditText
    private lateinit var editBgColorValue: EditText
    private lateinit var errorView: TextView

    private var errorString: String = "Тут будут ошибки"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_counter)

        editCounterValue = findViewById(R.id.counter_digit_edittext)
        editTextColorValue = findViewById(R.id.color_edittext)
        editBgColorValue = findViewById(R.id.bg_edittext)
        errorView = findViewById(R.id.error_text)

        val savedErrMsg = savedInstanceState?.getString(ERROR_MSG_KEY)
        if (savedErrMsg != null) {
            errorView.text = savedErrMsg
            errorString = savedErrMsg
        }

        val savedCounterValue = savedInstanceState?.getString(COUNTER_VALUE_KEY)
        if (savedCounterValue != null) {
            editCounterValue.setText(savedCounterValue)
        }

        val savedTextColor = savedInstanceState?.getString(TEXT_COLOR_VALUE_KEY)
        if (savedTextColor != null) {
            editTextColorValue.setText(savedTextColor)
        }

        val savedBgColor = savedInstanceState?.getString(BG_COLOR_VALUE_KEY)
        if (savedBgColor != null){
            editBgColorValue.setText(savedBgColor)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ERROR_MSG_KEY, errorString)
        outState.putString(COUNTER_VALUE_KEY, editCounterValue.text.toString())
        outState.putString(TEXT_COLOR_VALUE_KEY, editTextColorValue.text.toString())
        outState.putString(BG_COLOR_VALUE_KEY, editBgColorValue.text.toString())
    }

    fun createCounter(view: View) {
        if ((view as Button).text == getString(R.string.btn_create)) {
            val intent = Intent(this, CounterActivity::class.java)
            val counterDigit = createCounterDigit()
            val textColor = createTextColor()
            val bgColor = createBgColor()

            if (counterDigit != null && textColor != null && bgColor != null) {
                intent.putExtra(COUNTER_VALUE_KEY, counterDigit)
                intent.putExtra(TEXT_COLOR_VALUE_KEY, textColor)
                intent.putExtra(BG_COLOR_VALUE_KEY, bgColor)
                errorView.text = "Тут будут ошибки"
                zeroFields()
                startActivity(intent)
            }
            else {
                errorView.text = errorString
                zeroFields()
            }
        }
    }

    private fun createCounterDigit(): Int? {
        var counterValue: Int? = null

        try {
            counterValue = editCounterValue.text.toString().toInt()
        } catch (ex: NumberFormatException) {
            errorString += "${getString(INCORRECT_VALUE_FORMAT)}\n"
            editCounterValue.setText("0")
        }

        return counterValue
    }

    private fun createTextColor(): Int? {
        var textColorValue: Int? = null
        val text = editTextColorValue.text.toString().lowercase()

        when (text) {
            "r" -> {
                textColorValue = R.color.text_red
            }
            "g" -> {
                textColorValue = R.color.text_green
            }
            "b" -> {
                textColorValue = R.color.text_blue
            }
            "m" -> {
                textColorValue = R.color.text_magenta
            }
            else -> {
                errorString += "${getString(INCORRECT_TXT_COLOR)}\n"
                editTextColorValue.setText("r")
            }
        }

        return textColorValue
    }

    private fun createBgColor(): Int? {
        var bgColorValue: Int? = null
        val text = editBgColorValue.text.toString().lowercase()

        when (text) {
            "1" -> {
                bgColorValue = R.color.bg_light_blue
            }
            "2" -> {
                bgColorValue = R.color.bg_light_green
            }
            "3" -> {
                bgColorValue = R.color.bg_light_pink
            }
            "4" -> {
                bgColorValue = R.color.bg_orange
            }
            else -> {
                errorString += "${getString(INCORRECT_BG_COLOR)}\n"
                editTextColorValue.setText("r")
            }
        }

        return bgColorValue
    }

    private fun zeroFields(){
        editCounterValue.setText("0")
        editTextColorValue.setText("r")
        editBgColorValue.setText("1")
        errorString = ""
    }

    companion object {
        const val COUNTER_VALUE_KEY = "COUNTER_VALUE_KEY"
        const val TEXT_COLOR_VALUE_KEY = "TEXT_COLOR_VALUE"
        const val BG_COLOR_VALUE_KEY = "BG_COLOR_VALUE"
        const val ERROR_MSG_KEY = "ERROR_MSG_KEY"

        const val INCORRECT_VALUE_FORMAT = R.string.incorrect_number_format_msg
        const val INCORRECT_TXT_COLOR = R.string.incorrect_txt_color_format_msg
        const val INCORRECT_BG_COLOR = R.string.incorrect_bg_format_msg
    }
}