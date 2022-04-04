package com.example.lessson17

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity() {

    private lateinit var intentInfoActivity: Intent
    private lateinit var intentImageActivity: Intent
    private lateinit var intentCounterActivity: Intent
    private lateinit var intentCreateCounter: Intent
    private lateinit var intentOthersApplication: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        Log.d(TAG, "Menu create")
        createIntentApp()
    }

    private fun createIntentApp() {
        intentInfoActivity = Intent(this, InfoActivity::class.java)
        intentImageActivity = Intent(this, ImageActivity::class.java)
        intentCounterActivity = Intent(this, CounterActivity::class.java)
        intentCreateCounter = Intent(this, CreateCounter::class.java)
        intentOthersApplication = Intent(this, OtherApplications::class.java)
    }

    fun menu(view: View) {
        when ((view as Button).text) {
            resources.getString(R.string.info_label) -> startActivity(intentInfoActivity)
            resources.getString(R.string.image_label) -> startActivity(intentImageActivity)
            resources.getString(R.string.counter_label) -> startActivity(intentCounterActivity)
            resources.getString(R.string.create_counter) -> startActivity(intentCreateCounter)
            getString(R.string.others) -> startActivity(intentOthersApplication)
            else -> error("unknown")
        }
    }

    companion object {
        private const val TAG = "lifecycle"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Menu start")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Menu pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Menu stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Menu destroy")
    }
}