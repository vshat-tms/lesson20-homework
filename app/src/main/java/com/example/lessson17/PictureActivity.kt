package com.example.lessson17

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity

class PictureActivity : AppCompatActivity() {

    @DrawableRes
    private var currentImageRes = R.drawable.cat
    private var rotation = ROTATION_ANGEL

    private lateinit var imageView: ImageView
    private lateinit var imagesMaps: Map<String, Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        imageView = findViewById(R.id.imageView)

        imagesMaps = mapOf(
            getString(R.string.cat_picture) to R.drawable.cat,
            getString(R.string.dog_picture) to R.drawable.dog,
            getString(R.string.parrot_picture) to R.drawable.parrot
        )

        val savedImgRes = savedInstanceState?.getInt(IMAGE_KEY)
        if (savedImgRes != null) {
            imageView.setImageResource(savedImgRes)
            currentImageRes = savedImgRes
        }

        imageView.setOnClickListener {
            updateRotation(rotation + IMAGE_ROTATION)
        }

    }

    private fun updateRotation(angle: Float) {
        rotation = angle
        imageView.rotation = rotation
    }

    fun pictureButtonClick(view: View) {
        val text = (view as Button).text
        var imageRes = imagesMaps[text]
        if (imageRes == null) {
            imageRes = (imagesMaps.values - currentImageRes).random()
        }
        updateRotation(ROTATION_ANGEL)
        currentImageRes = imageRes
        imageView.setImageResource(imageRes)

    }

    companion object {
        private const val ROTATION_ANGEL = 0F
        private const val IMAGE_ROTATION = 90
        const val IMAGE_KEY = "IMAGE"
    }
}