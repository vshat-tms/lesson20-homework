package com.example.lessson17

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class InfoActivity : AppCompatActivity() {

    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        infoTextView = findViewById(R.id.textView)
    }

    fun infoButtonClick(view: View) {
        when ((view as Button).text) {

            getString(R.string.device_btn) -> {
                infoTextView.text = Build.BRAND + " " + Build.MODEL
            }

            getString(R.string.time_btn) -> {
                infoTextView.text = SimpleDateFormat("HH:mm", Locale.US).format(Date())
            }

            getString(R.string.toast_btn) -> {
                Toast.makeText(this, TOAST, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val TOAST = "Vive Belarus"
    }
}