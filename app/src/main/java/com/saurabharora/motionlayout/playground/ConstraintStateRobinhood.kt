package com.saurabharora.motionlayout.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintsChangedListener
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_robinhood.*

/**
 * This Layout animation shown here is found in the Robinhood app and is talked about in the following post:
 * https://robinhood.engineering/beautiful-animations-using-android-constraintlayout-eee5b72ecae3
 *
 * The post only shows the animation but doesn't show the code on how to build it.
 *
 * I have tried to make it as close as possible
 */
class ConstraintStateRobinhood : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robinhood)

        supportActionBar?.let { it.elevation = 0f }

        root.loadLayoutDescription(R.xml.robinhood_constraint_state)

        fab.setOnClickListener { root.setState(R.id.end, 0, 0) }
        ivSwipeUp.setOnClickListener { root.setState(R.id.start, 0, 0) }

        root.setOnConstraintsChanged(object : ConstraintsChangedListener() {
            override fun preLayoutChange(stateId: Int, constraintId: Int) {
                TransitionManager.beginDelayedTransition(root)
            }
        })
    }
}
