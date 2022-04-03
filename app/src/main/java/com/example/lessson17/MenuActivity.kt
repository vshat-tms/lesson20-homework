package com.example.lessson17

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity() {

    private lateinit var counterButton: Button
    private lateinit var createCounterButton: Button
    private lateinit var imageButton: Button
    private lateinit var infoButton: Button
    private lateinit var mapsButton: Button
    private lateinit var webButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        counterButton = findViewById(R.id.counterButton)
        createCounterButton = findViewById(R.id.createCounterButton)
        imageButton = findViewById(R.id.imageButton)
        infoButton = findViewById(R.id.infoButton)
        mapsButton = findViewById(R.id.mapsButton)
        webButton = findViewById(R.id.webButton)
    }

    fun setIntent(view: View) {
        starNewActivity(
            when (view.id) {
                R.id.counterButton -> Intent(this, CounterActivity::class.java)
                R.id.createCounterButton -> Intent(this, CreateCounterActivity::class.java)
                R.id.imageButton -> Intent(this, ImageActivity::class.java)
                R.id.infoButton -> Intent(this, InfoActivity::class.java)
                R.id.mapsButton -> Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:-0.45609946,-90.26607513")
                )
                R.id.webButton -> Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=jYmeyW7oS1M")
                )
                else -> return
            }
        )
    }

    private fun starNewActivity(intent: Intent) {
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        private const val TAG = "MenuActivity info: "
    }
}