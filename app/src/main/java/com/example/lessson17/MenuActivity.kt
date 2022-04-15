package com.example.lessson17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Log.d(TAG, "MenuActivity создано")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MenuActivity onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MenuActivity становиться видимым")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MenuActivity получает фокус (состояние Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MenuActivity приостановлено (состояние Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MenuActivity остановлено (состояние Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MenuActivity уничтожено")
    }

    fun btnCounter(view: View) {
        val intentCounter = Intent(this, CounterActivity::class.java)
        startActivity(intentCounter)
        when ((view as Button).text) {
            "main" -> intentCounter
        }
    }

    fun btnAnimals(view: View) {
        val intentAnimals = Intent(this, AnimalsImageActivity::class.java)
        startActivity(intentAnimals)
        when ((view as Button).text) {
            "animals" -> intentAnimals
        }
    }

    fun btnInfo(view: View) {
        val intentInfo = Intent(this, InfoActivity::class.java)
        startActivity(intentInfo)
        when ((view as Button).text) {
            "info" -> intentInfo
        }
    }

    fun btnCreateCounter(view: View) {
        val intentCreateCounter = Intent(this, CreateCounterActivity::class.java)
        startActivity(intentCreateCounter)
        when ((view as Button).text) {
            "create counter" -> intentCreateCounter
        }
    }

    fun btnMyApplications(view: View) {
        val intentMyApplications = Intent(this, MyApplicationsActivity::class.java)
        startActivity(intentMyApplications)
        when ((view as Button).text) {
            "my applications" -> intentMyApplications
        }
    }

    companion object {
        private const val TAG = "Lifecycle"
    }
}