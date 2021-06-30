package com.fmohammadi.covid19.model

class Country() {
    var countryName: String? = null
    var countryCases: String? = null
    var countryTodayCases: String? = null
    var countryDeaths: String? = null
    var countryTodayDeaths: String? = null
    var countryRecovered: String? = null
    var countryTodayRecovered: String? = null
    var countryImage: String? = null
    var countryCritical: String? = null
    var countryNameFa: String? = null

    constructor(
        countryName: String,
        countryCases: String,
        countryTodayCases: String,
        countryDeaths: String,
        countryTodayDeaths: String,
        countryRecovered: String,
        countryTodayRecovered: String,
        countryImage: String,
        countryCritical:String,
        countryNameFa:String

    ) : this() {
        this.countryName = countryName
        this.countryCases = countryCases
        this.countryTodayCases = countryTodayCases
        this.countryDeaths = countryDeaths
        this.countryTodayDeaths = countryTodayDeaths
        this.countryRecovered = countryRecovered
        this.countryTodayRecovered = countryTodayRecovered
        this.countryImage = countryImage
        this.countryCritical = countryCritical
        this.countryNameFa = countryNameFa
    }

}