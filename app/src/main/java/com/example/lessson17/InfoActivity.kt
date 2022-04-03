package com.example.lessson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class InfoActivity : AppCompatActivity() {

    private lateinit var infoTextView: TextView

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_KEY, infoTextView.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        infoTextView = findViewById(R.id.info_textview)

        val savedTextValue = savedInstanceState?.getString(TEXT_KEY)
        if (savedInstanceState != null) {
            infoTextView.text = savedTextValue
        }
    }

    fun btnOnInfoClick(view: View) {

        when ((view as Button).text) {
            getString(R.string.btn_time) -> {
                infoTextView.text = SimpleDateFormat("HH:mm", Locale.US).format(Date())
            }
            getString(R.string.btn_device) -> {
                infoTextView.text = android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL
            }
            getString(R.string.btn_toast) -> {
                Toast.makeText(this, "Hello from InfoActivity",Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        const val TEXT_KEY = "TEXT_KEY"
    }
}