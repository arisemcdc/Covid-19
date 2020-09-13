package com.example.covid_19.data.Repository

import com.example.covid_19.data.Country
import com.example.covid_19.data.Covid19Api
import com.example.covid_19.data.DataResult
import com.example.covid_19.data.Response.TotalScores
//import com.example.covid_19.data.Response.TotalScoresResponse
import java.lang.Exception

class Repository (val localDB:RoomDB) {
    suspend fun getTotalScore(): DataResult<TotalScores> {
       val result = try {
           val data = Covid19Api.retrofitService.getTotalCases()
           localDB.TotalScoresDAO().insert(data)
           DataResult.Success(data)
        } catch (e: Exception) {
           val localData = localDB.TotalScoresDAO().getTotalScores()
           if (localData.isNotEmpty())
               DataResult.Success(localData[0])
           else
            DataResult.Error(e)
        }
        return result
    }
    suspend fun getCountriesScores(): DataResult<List<Country>> {
       val result = try {
           val data = Covid19Api.retrofitService.fetchAllCountries()
           //localDB.countriesDao().insert(data)
           DataResult.Success(data)
       } catch (e: Exception) {
           val localData = localDB.countriesDao().getCountries()
           if (localData.isNotEmpty())
               DataResult.Success(localData)
           else
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
