package com.example.lessson17

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.lessson17.CreateCounterActivity.Companion.TAG

class AppsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apps)
    }

    fun toGo(view: View) {
        when ((view as Button).text) {
            "Web" -> {
                val intentWeb = Intent(Intent.ACTION_VIEW, Uri.parse("https://stackoverflow.com/"))
                startActivity(intentWeb)
            }
            "Map" -> {
                val intentMap =
                    Intent(Intent.ACTION_VIEW, Uri.parse("geo:-0.45609946, -90.26607513"))
                startActivity(intentMap)
            }
            "Call" -> {
                val intentCall = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345"))
                startActivity(intentCall)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "AppsActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "AppsActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "AppsActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "AppsActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "AppsActivity onDestroy")
    }
}