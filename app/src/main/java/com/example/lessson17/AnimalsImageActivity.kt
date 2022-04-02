package com.example.lessson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.DrawableRes

class AnimalsImageActivity : AppCompatActivity() {
    private var rotation = 0F

    @DrawableRes
    private var currentImageRes = R.drawable.cat

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_image)

        imageView = findViewById(R.id.imageView)

        imageView.setOnClickListener {
            updateRotation(rotation + 90)

            Log.d(TAG, "AnimalsImageActivity создано")
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "AnimalsImageActivity onRestert")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "AnimalsImageActivity становиться видимым")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "AnimalsImageActivity получает фокус (состояние Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "AnimalsImageActivity приостановлено (состояние Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "AnimalsImageActivity остановлено (состояние Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "AnimalsImageActivity уничтожено")
    }

    private fun updateRotation(angle: Float) {
        rotation = angle
        imageView.rotation = rotation
    }

    fun setImage(view: View) {
        val text = (view as Button).text
        var imageRes = AnimalsImageActivity.IMAGES_MAP[text]
        if (imageRes == null) {
            imageRes = (AnimalsImageActivity.IMAGES_MAP.values - currentImageRes).random()
        }
        updateRotation(0f)
        currentImageRes = imageRes
        imageView.setImageResource(imageRes)
    }

    companion object {

        private const val TAG = "Lifecycle"

        private val IMAGES_MAP = mapOf(
            "cat" to R.drawable.cat,
            "dog" to R.drawable.dog,
            "parrot" to R.drawable.parrot,
        )
    }
}