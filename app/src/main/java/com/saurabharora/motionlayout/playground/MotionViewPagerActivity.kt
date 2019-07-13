package com.saurabharora.motionlayout.playground

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_motion_pager.*
import kotlinx.android.synthetic.main.fragment_dummy.*

const val COUNT = 3

class MotionViewPagerActivity : AppCompatActivity() {

    val motionRoot: MotionLayout by lazy {
        findViewById<MotionLayout>(R.id.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_pager)

        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int): Fragment {
                return DummyFragment()
                        .apply {
                           arguments = Bundle()
                                    .apply {
                                        putInt("count", position)
                                    }
                        }
            }

            override fun getCount(): Int {
                return COUNT
            }
        }

        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                motionRoot.progress = (position + positionOffset) / (COUNT - 1)
            }
        })
    }
}

class DummyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dummy, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val count = arguments?.getInt("count", 0)
        tvDummyText.text = "Dummy Fragment content $count"
    }
}