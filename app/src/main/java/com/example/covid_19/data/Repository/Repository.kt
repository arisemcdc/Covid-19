package com.example.covid_19.data.Repository

import com.example.covid_19.data.Country
import com.example.covid_19.data.Covid19Api
import com.example.covid_19.data.DataResult
import com.example.covid_19.data.Response.TotalScoresResponse
import java.lang.Exception

class Repository () {
    suspend fun getTotalScore(): DataResult<TotalScoresResponse> {
       val result = try {
           DataResult.Success(Covid19Api.retrofitService.getTotalCases())
        } catch (e: Exception) {
            DataResult.Error(e)
        }
        return result
    }

    init {

    }
    /*//val countries = arrayListOf<Country>()
    val countries = localDB.countries
    val totalScores = localDB.totalScores
    *//*fun insertCountry(country: Country){
        localDB.insertCountry(country)
    }
    fun insertTotalScores(totalScores: TotalScoresResponse) {
        localDB.insertTotalScores(totalScores)
    }*/
}
