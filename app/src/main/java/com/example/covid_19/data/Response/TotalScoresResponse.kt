package com.example.covid_19.data.Response


import com.google.gson.annotations.SerializedName

data class TotalScoresResponse(
    var active: Int,
    var activePerOneMillion: Double,
    var affectedCountries: Int,
    var cases: Int,
    var casesPerOneMillion: Int,
    var critical: Int,
    var criticalPerOneMillion: Double,
    var deaths: Int,
    var deathsPerOneMillion: Int,
    var oneCasePerPeople: Int,
    var oneDeathPerPeople: Int,
    var oneTestPerPeople: Int,
    var population: Long,
    var recovered: Int,
    var recoveredPerOneMillion: Double,
    var tests: Int,
    var testsPerOneMillion: Double,
    var todayCases: Int,
    var todayDeaths: Int,
    var todayRecovered: Int,
    var updated: Long
)