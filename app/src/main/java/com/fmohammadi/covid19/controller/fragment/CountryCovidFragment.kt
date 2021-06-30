package com.fmohammadi.covid19.controller.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.fmohammadi.covid19.model.Country
import com.fmohammadi.covid19.controller.adapter.CountryAdapter
import com.fmohammadi.covid19.R
import com.fmohammadi.covid19.model.getTranslate
import kotlinx.android.synthetic.main.fragment_country_covid.*
import org.json.JSONException
import org.json.JSONObject


class CountryCovidFragment : Fragment() {

    private var URL = "https://corona.lmao.ninja/v2/countries"
    private var countryList: ArrayList<Country>? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private var adapterCountry: CountryAdapter? = null
    private var volleyRequest: RequestQueue? = null

    private var countryObject: JSONObject? = null
    private var countryImage: JSONObject? = null
    private var nameCountry: String? = null
    private var nameFaCountry: String? = "پیش فرض"
    private var casesCountry: String? = null
    private var deathsCountry: String? = null
    private var recoveredCountry: String? = null
    private var imageCountry: String? = null
    private var todayCasesCountry: String? = null
    private var todayDeathsCountry: String? = null
    private var todayRecoveredCountry: String? = null
    private var criticalCountry: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_covid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        volleyRequest = Volley.newRequestQueue(context)
        getJsonArray()

        countryList = ArrayList()
        linearLayoutManager = LinearLayoutManager(context)
        adapterCountry = CountryAdapter(context!!, countryList!!)


    }

    private fun getJsonArray() {
        val jsonArray = JsonArrayRequest(Request.Method.GET,
            URL, { response ->
                try {
                    progressBarCountry.visibility = View.GONE
                    countryRecyclerView.visibility = View.VISIBLE
                    for (index in 0 until response.length()) {
                        countryObject = response.getJSONObject(index)
                        nameCountry = countryObject!!.getString("country")
                        casesCountry = countryObject!!.getString("cases")
                        todayCasesCountry = countryObject!!.getString("todayCases")
                        deathsCountry = countryObject!!.getString("deaths")
                        todayDeathsCountry = countryObject!!.getString("todayDeaths")
                        recoveredCountry = countryObject!!.getString("recovered")
                        todayRecoveredCountry = countryObject!!.getString("todayRecovered")
                        criticalCountry = countryObject!!.getString("critical")
                        countryImage = countryObject!!.getJSONObject("countryInfo")
                        imageCountry = countryImage!!.getString("flag")

                        countryList!!.add(
                            Country(
                                nameCountry!!,
                                casesCountry!!,
                                todayCasesCountry!!,
                                deathsCountry!!,
                                todayDeathsCountry!!,
                                recoveredCountry!!,
                                todayRecoveredCountry!!,
                                imageCountry!!,
                                criticalCountry!!,
                                getTranslate(nameCountry!!)
                            )
                        )
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Log.d("Error Volley", e.toString())
                    progressBarCountry.visibility = View.VISIBLE
                    countryRecyclerView.visibility = View.GONE
                }
                countryRecyclerView.layoutManager = linearLayoutManager
                countryRecyclerView.adapter = adapterCountry
            },
            {
                Log.d("Error Volley", it.toString())
                progressBarCountry.visibility = View.VISIBLE
                countryRecyclerView.visibility = View.GONE
            }
        )
        volleyRequest!!.add(jsonArray)
    }


}