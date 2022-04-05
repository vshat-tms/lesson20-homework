package com.example.lessson17

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MenuActivity : AppCompatActivity() {

    private val counterActivity = Intent(this, CounterActivity::class.java)
    private val crateCounterActivity = Intent(this, CreateCounterActivity::class.java)
    private val imageActivity = Intent(this, ImageActivity::class.java)
    private val infoActivity = Intent(this, InfoActivity::class.java)
    private val mapsActivity = Intent(Intent.ACTION_VIEW, Uri.parse(GEO_TAG))
    private val webActivity = Intent(Intent.ACTION_VIEW, Uri.parse(WEB_LINK))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun setIntent(view: View) {
        when (view.id) {
            R.id.counterButton -> startActivity(counterActivity)
            R.id.createCounterButton -> startActivity(crateCounterActivity)
            R.id.imageButton -> startActivity(imageActivity)
            R.id.infoButton -> startActivity(infoActivity)
            R.id.mapsButton -> startActivity(mapsActivity)
            R.id.webButton -> startActivity(webActivity)
            else -> error(R.string.unknown_command)
        }
    }

    companion object {
        private const val TAG = "MenuActivity info: "
        private const val GEO_TAG = "geo: 53.962556, 27.427672"
        private const val WEB_LINK = "https://www.youtube.com/watch?v=jYmeyW7oS1M"
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
}