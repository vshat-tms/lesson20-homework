package com.example.lessson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.graphics.drawable.toDrawable

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(IMAGE_KEY, currentImageRes)
        outState.putFloat(IMAGE_ROTATION_KEY, rotation)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currentImageRes = savedInstanceState.getInt(IMAGE_KEY)
        imageView.setImageResource(currentImageRes)
        rotation = savedInstanceState.getFloat(IMAGE_ROTATION_KEY)
        imageView.rotation = rotation
    }

    private fun updateRotation(angle: Float) {
        rotation = angle
        imageView.rotation = rotation
    }

    fun setImage(view: View) {
        val text = (view as Button).text
        var imageRes = IMAGES_MAP[text]
        if (imageRes == null) {
            imageRes = (IMAGES_MAP.values - currentImageRes).random()
        }
        updateRotation(0f)
        currentImageRes = imageRes
        imageView.setImageResource(imageRes)
    }

    companion object {
        private const val IMAGE_KEY = "image"
        private const val IMAGE_ROTATION_KEY = "image rotation"

        private const val TAG = "Lifecycle"

        private val IMAGES_MAP = mapOf(
            "cat" to R.drawable.cat,
            "dog" to R.drawable.dog,
            "parrot" to R.drawable.parrot,
        )
    }
}