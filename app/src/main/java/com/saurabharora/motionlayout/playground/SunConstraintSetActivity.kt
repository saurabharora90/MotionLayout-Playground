package com.saurabharora.motionlayout.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_sun_constraint.*

class SunConstraintSetActivity : AppCompatActivity() {

    private val constraintSetEnd by lazy {
        val set = ConstraintSet()
        set.clone(this, R.layout.activity_sun_constraint_alt)
        set
    }

    private val constraintSetStart by lazy {
        val set = ConstraintSet()
        set.clone(this, R.layout.activity_sun_constraint)
        set
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sun_constraint)

        if(root !is MotionLayout)
            start()
    }

    fun start() {
        root.postDelayed({
            TransitionManager.beginDelayedTransition(root, AutoTransition().apply {
                duration = 1000
            })
            constraintSetEnd.applyTo(root)

            //end()
        }, 3000)
    }

    fun end() {
        root.postDelayed({
            TransitionManager.beginDelayedTransition(root, AutoTransition().apply {
                duration = 1000
            })
            constraintSetStart.applyTo(root)

            start()
        }, 3000)
    }

}