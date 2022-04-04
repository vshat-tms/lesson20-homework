package com.example.lessson17

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Log.d(TAG, "Activity create")
    }

    fun choseActivity(view: View) {

        val counterActivity = Intent(this, CounterActivity::class.java)
        val infoActivity = Intent(this, InfoActivity::class.java)
        val imageActivity = Intent(this, ImageActivity::class.java)
        val createCounterActivity = Intent(this, CreateCounterActivity::class.java)
        val appsActivity = Intent(this, AppsActivity::class.java)

        when ((view as Button).text) {
            getString(R.string.button_counter) -> startActivity(counterActivity)
            getString(R.string.button_info) -> startActivity(infoActivity)
            getString(R.string.button_image) -> startActivity(imageActivity)
            getString(R.string.button_create_counter) -> startActivity(createCounterActivity)
            getString(R.string.button_apps) -> startActivity(appsActivity)
            else -> error(R.string.error)
        }
    }

    companion object {
        private const val TAG = "menu activity"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Activity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Activity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Activity destroyed")
    }
}