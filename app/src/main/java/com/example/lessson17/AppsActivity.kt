package com.example.lessson17

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AppsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apps)
    }

    fun onClick(view: View) {

        when ((view as Button).text) {
            getString(R.string.button_web) -> {
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/GansA11es"))
                startActivity(intent)
            }
            getString(R.string.button_map) -> {
                intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:55.75443537194408, 37.62129585582125")
                )
                startActivity(intent)
            }
            getString(R.string.button_call) -> {
                intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("tel:")
                )
                startActivity(intent)
            }
        }
    }
}