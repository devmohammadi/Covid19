package com.fmohammadi.covid19.controller.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fmohammadi.covid19.controller.fragment.CountryCovidFragment
import com.fmohammadi.covid19.controller.fragment.ResultCovidFragment
import java.util.*

@Suppress("UNREACHABLE_CODE")
class SectionPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
       when(position){
           0 -> return ResultCovidFragment()
           1 -> return CountryCovidFragment()
       }
        return null!!
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return if(Locale.getDefault().displayLanguage == "فارسی") "نتایج کلی" else "Result COVID19"
            1 -> return if(Locale.getDefault().displayLanguage == "فارسی") "نتایج کشورها" else "Country COVID19"
        }
        return null!!
    }
}