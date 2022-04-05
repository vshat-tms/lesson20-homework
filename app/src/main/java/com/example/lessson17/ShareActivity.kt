package com.example.lessson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShareActivity : AppCompatActivity() {

    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        text = findViewById(R.id.textPersonName)
        text.text = intent.getStringExtra(TO_GET_DATA)
    }

    companion object {
        private const val TO_GET_DATA = "android.intent.extra.TEXT"
    }
}