package com.fmohammadi.covid19.controller.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.fmohammadi.covid19.R
import kotlinx.android.synthetic.main.activity_country_details.*

class CountryDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)
        detailCountryName.text = intent.extras!!.getString("countryName")
        Glide
            .with(this)
            .load(intent.extras!!.getString("countryImage"))
            .centerCrop()
            .placeholder(R.drawable.country)
            .into(detailCountryImage)
        detailsCasesResult.text = intent.extras!!.getString("countryCases")
        detailsTodayCasesResult.text = intent.extras!!.getString("countryTodayCases")
        detailsDeathsResult.text = intent.extras!!.getString("countryDeaths")
        detailsTodayDeathsResult.text = intent.extras!!.getString("countryTodayDeaths")
        detailsRecoveredResult.text = intent.extras!!.getString("countryRecovered")
        detailsTodayRecoveredResult.text = intent.extras!!.getString("countryTodayRecovered")
        detailsCriticalResult.text = intent.extras!!.getString("countryCritical")
    }
}