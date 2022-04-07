package com.example.lessson17

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ShareActivity : AppCompatActivity() {
    private lateinit var textScreenShare: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        textScreenShare = findViewById(R.id.textShare)
        textScreenShare.text = intent.getStringExtra("android.intent.extra.SUBJECT")

    }
}