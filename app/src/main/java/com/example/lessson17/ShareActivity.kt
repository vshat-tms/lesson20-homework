package com.example.lessson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ShareActivity : AppCompatActivity() {
    private lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        text = findViewById(R.id.text_share)
        text.text = intent.getStringExtra("android.intent.extra.TEXT")
        Log.d("what is ", "${text.text} / ${intent.getStringExtra("android.intent.extra.TEXT")}")
    }
}