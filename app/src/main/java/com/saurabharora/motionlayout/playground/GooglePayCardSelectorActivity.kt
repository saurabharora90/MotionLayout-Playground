package com.saurabharora.motionlayout.playground

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import com.google.android.material.card.MaterialCardView

class GooglePayCardSelectorActivity : AppCompatActivity() {

    private val creditCards = intArrayOf(
        R.drawable.citi,
        R.drawable.standard_chartered,
        R.drawable.mastercard,
    )

    private val cardNumber = arrayOf(
        "**** 1234",
        "**** 4567",
        "**** 7890",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_pay_card_selector)

        setupCarousel()
    }

    private fun setupCarousel() {
        val carousel = findViewById<Carousel>(R.id.carousel)
        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return 3
            }

            override fun populate(view: View, index: Int) {
                val cardView = view as MaterialCardView
                cardView.findViewById<ImageView>(R.id.ivCreditCard)
                    .setImageResource(creditCards[index])
                cardView.findViewById<TextView>(R.id.cardNumber).text = cardNumber[index]
            }

            override fun onNewItem(index: Int) {
            }
        })
    }
}