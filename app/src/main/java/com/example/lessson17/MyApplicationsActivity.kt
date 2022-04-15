package com.example.lessson17

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MyApplicationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_applications)
    }

    fun btnWeb(view: View) {
        val intentWeb = Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"))
        startActivity(intentWeb)
        when ((view as Button).text) {
            "web" -> intentWeb
        }
    }

    fun btnMap(view: View) {
        val intentMap = Intent()
        intentMap.setAction(Intent.ACTION_VIEW)
        intentMap.setData(Uri.parse("geo: 54.199734,27.837643"))
        startActivity(intentMap)
    }

    fun btnCall(view: View) {
        val intentCall = Intent()
        intentCall.setAction(Intent.ACTION_VIEW)
        intentCall.setData(Uri.parse("tel: 8029 7736453"))
        startActivity(intentCall)
    }
}