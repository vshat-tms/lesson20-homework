package com.example.lessson17

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class OtherApplications : AppCompatActivity() {

    private lateinit var intentMap: Intent
    private lateinit var intentWeb: Intent
    private lateinit var intentCall: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_applications)
        intentMap = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("geo:60.184379069023365, 24.933516953498586")
        )
        intentWeb = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
        )
        intentCall = Intent(Intent.ACTION_DIAL, Uri.parse("tel:666"))
    }

    fun setApp(view: View) {
        when ((view as Button).text) {
            getString(R.string.map) -> startActivity(intentMap)
            getString(R.string.web) -> startActivity(intentWeb)
            getString(R.string.call) -> startActivity(intentCall)
        }
    }
}