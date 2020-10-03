package com.example.covid_19.data

import com.example.covid_19.data.Response.TotalScores
//import com.example.covid_19.data.Response.TotalScoresResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = " https://corona.lmao.ninja2"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface ApiServiceTotalScores {
    @GET("/v3/covid-19/all")
    suspend fun getTotalCases(): TotalScores
    @GET("/v2/countries")
    suspend fun fetchAllCountries(): List<Country>
    @GET("/v2/countries/{countryId}")
    suspend fun getCountry(@Path("countryId")countryId: Int)
}
object Covid19Api {
    val retrofitService : ApiServiceTotalScores by lazy {
        retrofit.create(ApiServiceTotalScores::class.java) }
}

