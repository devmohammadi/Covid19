package com.fmohammadi.covid19.controller.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fmohammadi.covid19.model.Country
import com.fmohammadi.covid19.controller.activity.CountryDetailsActivity
import com.fmohammadi.covid19.R
import kotlinx.android.synthetic.main.item_country.view.*
import java.util.*
import kotlin.collections.ArrayList

class CountryAdapter(var mContext: Context, var mCountryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View, var mCountry: ArrayList<Country>) :
        RecyclerView.ViewHolder(itemView) {
        var nameCountry = itemView.findViewById<TextView>(R.id.tvCountryName)
        var casesCountry = itemView.findViewById<TextView>(R.id.tvCountryCasesResult)
        var deathsCountry = itemView.findViewById<TextView>(R.id.tvCountryDeathsResult)
        var recoveredCountry = itemView.findViewById<TextView>(R.id.tvCountryRecoveredResult)
        var imageCountry = itemView.findViewById<ImageView>(R.id.imageCountry)


        fun bindViews(mContext: Context, mCountryList: Country) {
            if(Locale.getDefault().displayLanguage == "فارسی"){
                nameCountry.text = mCountryList.countryNameFa
            }
            else{
                nameCountry.text = mCountryList.countryName
            }
            casesCountry.text = mCountryList.countryCases
            deathsCountry.text = mCountryList.countryDeaths
            recoveredCountry.text = mCountryList.countryRecovered

            Glide
                .with(mContext)
                .load(mCountryList.countryImage)
                .centerCrop()
                .placeholder(R.drawable.country)
                .into(imageCountry)

            val pos = adapterPosition
            val country: Country = mCountry[pos]
            itemView.countryCardView.setOnClickListener {
                val intentCountry = Intent(mContext, CountryDetailsActivity::class.java)
                if(Locale.getDefault().displayLanguage == "فارسی"){
                    intentCountry.putExtra("countryName", country.countryNameFa)
                }
                else{
                    intentCountry.putExtra("countryName", country.countryName)
                }
                intentCountry.putExtra("countryCases", country.countryCases)
                intentCountry.putExtra("countryTodayCases", country.countryTodayCases)
                intentCountry.putExtra("countryDeaths", country.countryDeaths)
                intentCountry.putExtra("countryTodayDeaths", country.countryTodayDeaths)
                intentCountry.putExtra("countryRecovered", country.countryRecovered)
                intentCountry.putExtra("countryTodayRecovered", country.countryTodayRecovered)
                intentCountry.putExtra("countryImage", country.countryImage)
                intentCountry.putExtra("countryCritical", country.countryCritical)

                mContext.startActivity(intentCountry)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_country, parent, false)
        return ViewHolder(view, mCountryList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(mContext, mCountryList[position])
    }

    override fun getItemCount(): Int {
        return mCountryList.count()
    }
}

