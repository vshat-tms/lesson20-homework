package com.example.lessson17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.lessson17.CreateCounterActivity.Companion.TAG

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MenuActivity onCreate")
        setContentView(R.layout.activity_menu)
    }

    fun goTo(view: View) {
        when ((view as Button).text) {
            "Main" -> {
                val intentMain = Intent(this, CreateCounterActivity::class.java)
                startActivity(intentMain)
            }
            "Animal" -> {
                val intentAnimal = Intent(this, AnimalActivity::class.java)
                startActivity(intentAnimal)
            }
            "Info" -> {
                val intentInfo = Intent(this, InfoActivity::class.java)
                startActivity(intentInfo)
            }
            "Apps" -> {
                val intentApps = Intent(this, AppsActivity::class.java)
                startActivity(intentApps)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MenuActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MenuActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MenuActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MenuActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MenuActivity onDestroy")
    }
}