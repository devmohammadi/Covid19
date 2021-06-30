package com.fmohammadi.covid19.controller.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.fmohammadi.covid19.R
import kotlinx.android.synthetic.main.fragment_result_covid.*
import org.json.JSONException


class ResultCovidFragment : Fragment() {

    private var URL = "https://corona.lmao.ninja/v2/all";
    private var volleyRequest: RequestQueue? = null
    private var cases: String? = null
    private var deaths: String? = null
    private var recovered: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        volleyRequest = Volley.newRequestQueue(context)
        getJsonObject()
        return inflater.inflate(R.layout.fragment_result_covid, container, false)
    }


    override fun onResume() {
        super.onResume()
       /* btnLanguage.setOnCheckedChangeListener { _, isChecked ->
            Log.d("TAG", "onCreateView: ${Locale.getDefault().displayLanguage}")
            if (Locale.getDefault().displayLanguage == "فارسی") {
                if (isChecked) {
                    saveLanguage("en")
                    loadLanguage()
                } else {
                    saveLanguage("fa")
                    loadLanguage()
                }
            }

            if (Locale.getDefault().displayLanguage != "فارسی") {
                if (isChecked) {
                    saveLanguage("fa")
                    loadLanguage()
                } else {
                    saveLanguage("en")
                    loadLanguage()
                }
            }
        }*/
    }

    fun getJsonObject() {
        val jsonObject = JsonObjectRequest(Request.Method.GET,
            URL, {
                it
                try {
                    progressBarResult.visibility = View.GONE
                    resultId.visibility = View.VISIBLE
                    cases = it.getString("cases")
                    deaths = it.getString("deaths")
                    recovered = it.getString("recovered")

                    tvLabelTotalConfirmed.text = cases
                    tvLabelTotalDeaths.text = deaths
                    tvLabelTotalRecoverd.text = recovered

                } catch (e: JSONException) {
                    progressBarResult.visibility = View.VISIBLE
                    resultId.visibility = View.GONE
                    e.printStackTrace()
                }
            },
            { error: VolleyError? ->
                progressBarResult.visibility = View.VISIBLE
                resultId.visibility = View.GONE
                Log.d("error", error!!.message!!)
            }
        )
        volleyRequest!!.add(jsonObject)
    }

   /* fun saveLanguage(type: String) {
        var myPref: SharedPreferences? = null
        myPref = this.activity!!.getSharedPreferences("MY_LANGUAGE", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = myPref!!.edit()
        editor.putString("myLanguage", type)
        editor.apply()
        editor.commit()
    }

    fun loadLanguage() {
        val prefs: SharedPreferences =
            this.activity!!.getSharedPreferences("MY_LANGUAGE", MODE_PRIVATE)
        prefs.getString("myLanguage", "")?.let { Log.e("LanguageType", it) };
        if (prefs.getString("myLanguage", "").equals("fn")) {
            setLanguage("fn")
        } else if (prefs.getString("myLanguage", "").equals("en")) {
            setLanguage("en")
        }
        prefs.getString("myLanguage", "")?.let { Log.e("LanguageType", it) }
    }

    fun setLanguage(lang: String) {
        val locale: Locale = Locale(lang)
        Locale.setDefault(locale)
        val config: Configuration = Configuration()
        config.locale = locale
        this.activity!!.baseContext.resources.updateConfiguration(
            config,
            this.activity!!.baseContext.resources.displayMetrics
        )
        Log.d("TAG", "setLanguage: loaded")
        this.activity!!.startActivity(Intent(this.activity, MainActivity::class.java))
        this.activity!!.finish()
    }*/

}