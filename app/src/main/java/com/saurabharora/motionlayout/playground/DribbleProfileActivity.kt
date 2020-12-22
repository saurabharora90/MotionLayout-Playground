package com.saurabharora.motionlayout.playground

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import com.google.android.material.card.MaterialCardView

class DribbleProfileActivity : AppCompatActivity() {

    var colors = intArrayOf(
        Color.BLUE,
        Color.RED,
        Color.GREEN,
        Color.MAGENTA,
        Color.CYAN,
        Color.YELLOW,
        Color.parseColor("#DDEDED"),
        Color.parseColor("#00ABAB"),
        Color.BLACK,
        Color.parseColor("#9932CC"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dribble_profile)

        setupCarousel()
    }

    ////////////////////////////////////////////////////////////////
    // Setup the Carousel adapter
    ////////////////////////////////////////////////////////////////
    private fun setupCarousel() {
        val carousel = findViewById<Carousel>(R.id.carousel)
        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return 5
            }

            override fun populate(view: View, index: Int) {
                Log.d("Saurabh", "populate() called with: view = $view, index = $index")
                val cardView = view as MaterialCardView
                cardView.findViewById<View>(R.id.color).setBackgroundColor(colors[index])
            }

            override fun onNewItem(index: Int) {
            }
        })
    }
}