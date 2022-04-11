package com.example.lessson17

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun onClickButton(view: View) {

        when ((view as Button).text) {

            getString(R.string.counter_btn) -> {
                val mainActivity = Intent(this, CounterActivity::class.java)
                startActivity(mainActivity)
            }

            getString(R.string.picture_btn) -> {
                val pictureActivity = Intent(this, PictureActivity::class.java)
                startActivity(pictureActivity)
            }

            getString(R.string.info_btn) -> {
                val infoActivity = Intent(this, InfoActivity::class.java)
                startActivity(infoActivity)
            }

            getString(R.string.create_btn) -> {
                val createCounterActivity = Intent(this, CreateCounterActivity::class.java)
                startActivity(createCounterActivity)
            }

            getString(R.string.web_btn) -> {
                val webIntent = Intent()
                webIntent.action = Intent.ACTION_VIEW
                webIntent.data = Uri.parse("https://www.youtube.com/watch?v=7cbI2s0i1Ns")
                startActivity(webIntent)
            }
            getString(R.string.map_btn) -> {
                val mapIntent = Intent()
                mapIntent.action = Intent.ACTION_VIEW
                mapIntent.data = Uri.parse("geo: -16.497888473042636, -151.7336574219718")
                startActivity(mapIntent)
            }
        }
    }
}
