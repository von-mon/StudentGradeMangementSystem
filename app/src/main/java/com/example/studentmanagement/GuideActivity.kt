package com.example.studentmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.studentmanagement.adapter.ViewPagerAdapter

class GuideActivity : AppCompatActivity() {
    private lateinit var mViewPagerAdapter: ViewPagerAdapter
    private lateinit var mViewPager: ViewPager2
    private val mImages = arrayListOf(R.drawable.img_01, R.drawable.img_02, R.drawable.img_03, R.drawable.img_04)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        val radioGroup = findViewById<RadioGroup>(R.id.guideGroup)
        val radioGuideFirst = findViewById<RadioButton>(R.id.guideFirst)
        val radioGuideSecond = findViewById<RadioButton>(R.id.guideSecond)
        val radioGuideThird = findViewById<RadioButton>(R.id.guideThird)
        val radioGuideFourth = findViewById<RadioButton>(R.id.guideFourth)
        val start = findViewById<Button>(R.id.btnStart)
        start.visibility = View.GONE
        mViewPagerAdapter = ViewPagerAdapter(this, mImages)
        mViewPager = findViewById(R.id.viewPager)
        mViewPager.adapter = mViewPagerAdapter

        mViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        radioGuideFirst.isChecked = true
                        start.visibility = View.GONE
                    }
                    1 -> {
                        radioGuideSecond.isChecked = true
                        start.visibility = View.GONE
                    }
                    2 -> {
                        radioGuideThird.isChecked = true
                        start.visibility = View.GONE
                    }
                    else -> {
                        start.visibility = View.VISIBLE
                        radioGuideFourth.isChecked = true
                    }
                }
            }
        })

        start.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            run {
                when (checkedId) {
                    R.id.guideFirst -> mViewPager.currentItem = 0
                    R.id.guideSecond -> mViewPager.currentItem = 1
                    R.id.guideThird -> mViewPager.currentItem = 2
                    R.id.guideFourth -> mViewPager.currentItem = 3
                }
            }
        }

    }
}