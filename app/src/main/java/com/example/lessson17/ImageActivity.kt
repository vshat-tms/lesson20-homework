package com.example.lessson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.DrawableRes

class ImageActivity : AppCompatActivity() {

    private var rotation = DEFAULT_IMAGE_ROTATION
    private lateinit var imagesMap: Map<String, Int>

    @DrawableRes
    private var currentImageRes = R.drawable.dog
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        imageView = findViewById(R.id.imageView)
        imageView.setOnClickListener {
            updateRotation(rotation + IMAGE_ROTATION_ON_CLICK)
        }

        imagesMap = mapOf(
            getString(R.string.cat) to R.drawable.cat,
            getString(R.string.dog) to R.drawable.dog,
            getString(R.string.parrot) to R.drawable.parrot
        )
    }

    fun setImage(view: View) {
        val text = (view as Button).text
        var imageRes = imagesMap[text]
        if (imageRes == null) {
            imageRes = (imagesMap.values - currentImageRes).random()
        }
        updateRotation(DEFAULT_IMAGE_ROTATION)
        currentImageRes = imageRes
        imageView.setImageResource(imageRes)
    }

    private fun updateRotation(angle: Float) {
        rotation = angle
        imageView.rotation = rotation
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        private const val TAG = "ImageActivity lifecycle"
        private const val DEFAULT_IMAGE_ROTATION = 0f
        private const val IMAGE_ROTATION_ON_CLICK = 90f
    }
}