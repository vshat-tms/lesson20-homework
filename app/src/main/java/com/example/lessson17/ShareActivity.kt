package com.example.lessson17

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ShareActivity : AppCompatActivity() {
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        val intent = intent

        editText = findViewById(R.id.editTextTextPersonName)
        editText.setText(intent.getStringExtra("android.intent.extra.TEXT"))
    }
}