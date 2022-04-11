package com.example.lessson17

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShareActivity : AppCompatActivity() {
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        text = findViewById(R.id.share_textView)
        text.text = intent.getStringExtra("android.intent.extra.TEXT")
    }
}