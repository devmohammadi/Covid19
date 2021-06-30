package com.fmohammadi.covid19.controller.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fmohammadi.covid19.R
import com.fmohammadi.covid19.controller.adapter.SectionPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var sectionAdapter: SectionPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sectionAdapter = SectionPagerAdapter(supportFragmentManager)
        viewPager.adapter = sectionAdapter
        mainTab.setupWithViewPager(viewPager)
        mainTab.setTabTextColors(R.color.colorAccent100,Color.WHITE)

    }
}