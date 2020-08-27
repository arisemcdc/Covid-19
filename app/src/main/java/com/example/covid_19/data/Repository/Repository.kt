package com.example.covid_19.data.Repository

import com.example.covid_19.data.Country
import com.example.covid_19.data.Response.TotalScoresResponse

class Repository (
    val localDB: LocalDB) {

    //val countries = arrayListOf<Country>()
    val countries = localDB.countries
    val totalScores = localDB.totalScores
    /*fun insertCountry(country: Country){
        localDB.insertCountry(country)
    }
    fun insertTotalScores(totalScores: TotalScoresResponse) {
        localDB.insertTotalScores(totalScores)
    }*/
}
