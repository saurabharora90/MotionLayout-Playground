package com.saurabharora.motionlayout.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dialer.*

class DialerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialer)

        eightKey.setOnClickListener {
            Toast.makeText(this, "Number 8 clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
