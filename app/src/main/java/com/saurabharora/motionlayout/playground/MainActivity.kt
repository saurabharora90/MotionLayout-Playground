package com.saurabharora.motionlayout.playground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tvConstraintState -> {
                startActivity(Intent(this, ConstraintStateRobinhood::class.java))
            }
            R.id.tvSimpleMotion -> {
                startActivity(Intent(this, ConstraintStateRobinhood::class.java))
            }
            R.id.tvTwoViews -> {
                startActivity(Intent(this, ConstraintStateRobinhood::class.java))
            }
            R.id.tvttributes -> {
                startActivity(Intent(this, ConstraintStateRobinhood::class.java))
            }
            R.id.tvKeyFrame -> {
                startActivity(Intent(this, KeyFrameActivity::class.java))
            }
        }
    }
}
