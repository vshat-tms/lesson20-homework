package com.example.lessson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.lessson17.CreateCounterActivity.Companion.TAG

class AnimalActivity : AppCompatActivity() {

    private var rotation = 0f
    private var currentImageRes = R.drawable.cat
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)
        Log.d(TAG, "AnimalActivity onCreate")
        imageView = findViewById(R.id.imageView)
        imageView.setOnClickListener {
            updateRotation(rotation + 90)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "AnimalActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "AnimalActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "AnimalActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "AnimalActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "AnimalActivity onDestroy")
    }

    companion object {
        private val IMAGES_MAP = mapOf(
            "cat" to R.drawable.cat,
            "dog" to R.drawable.dog,
            "parrot" to R.drawable.parrot,
        )
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
}