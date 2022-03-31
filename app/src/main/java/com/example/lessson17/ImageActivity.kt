package com.example.lessson17

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {
    private var rotation = START_IMAGE_ANGLE
    private lateinit var imagesMap: Map<String, Int>

    @DrawableRes
    private var currentImageRes = R.drawable.cat
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        Log.d(TAG, "onCreate")

        imageView = findViewById(R.id.imageView)
        imageView.setOnClickListener {
            updateRotation(rotation + IMAGE_ANGLE_STEP)
        }
        imagesMap = mapOf(
            getString(R.string.btn_cat) to R.drawable.cat,
            getString(R.string.btn_dog) to R.drawable.dog,
            getString(R.string.btn_parrot) to R.drawable.parrot,
        )
    }

    fun setImage(view: View) {
        val text = (view as Button).text
        var imageRes = imagesMap[text]
        if (imageRes == null) {
            imageRes = (imagesMap.values - currentImageRes).random()
        }
        updateRotation(START_IMAGE_ANGLE)
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
        private const val START_IMAGE_ANGLE = 0f
        private const val IMAGE_ANGLE_STEP = 90f
    }
}