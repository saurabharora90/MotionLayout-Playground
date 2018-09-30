package com.saurabharora.motionlayout.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurabharora.motionlayout.playground.adapter.AnimalAdapter
import kotlinx.android.synthetic.main.activity_custom.*

class CustomDrivenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_custom)

        val size = resources.getDimensionPixelSize(R.dimen.profile_image_size)
        ivProfile.setImageBitmap(ContextCompat.getDrawable(this, R.drawable.droid)?.toBitmap(width = size, height = size))

        val animalNames = mutableListOf<String>()
        animalNames.add("Horse")
        animalNames.add("Cow")
        animalNames.add("Camel")
        animalNames.add("Sheep")
        animalNames.add("Goat")

        rv.apply {
            layoutManager = LinearLayoutManager(this@CustomDrivenActivity)
            adapter = AnimalAdapter(this@CustomDrivenActivity, animalNames)
        }
    }
}