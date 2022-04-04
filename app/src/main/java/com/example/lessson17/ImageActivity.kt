package com.example.lessson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.DrawableRes

class ImageActivity : AppCompatActivity() {

    private var rotation = 0f

    @DrawableRes
    private var currentImageRes = R.drawable.cat

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        imageView = findViewById(R.id.imageView)

        imageView.setOnClickListener {
            updateRotation(rotation + 90)
        }
        Log.d(TAG, "Image activity create")
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

    private fun updateRotation(angle: Float) {
        rotation = angle
        imageView.rotation = rotation
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        rotation = savedInstanceState.getFloat(ROTATION_STATE)
        imageView.rotation = rotation
        currentImageRes = savedInstanceState.getInt(IMAGE_STATE)
        imageView.setImageResource(currentImageRes)
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putFloat(ROTATION_STATE, rotation)
        outState.putInt(IMAGE_STATE, currentImageRes)
        super.onSaveInstanceState(outState)
    }

    companion object {
        private val IMAGES_MAP = mapOf(
            "cat" to R.drawable.cat,
            "dog" to R.drawable.dog,
            "parrot" to R.drawable.parrot,
        )
        private const val IMAGE_STATE = "image"
        private const val ROTATION_STATE = "rotation"
        private const val TAG = "lifecycle"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Image activity start")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Image activity pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Image activity stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Image activity destroy")
    }
}