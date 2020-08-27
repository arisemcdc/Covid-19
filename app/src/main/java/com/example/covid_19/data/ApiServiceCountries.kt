package com.example.covid_19.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL_COUNTRIES = " https://corona.lmao.ninja"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL_COUNTRIES)
    .build()
interface ApiServiceCountries {
    @GET("/v2/countries")
    fun fetchAllCountries(): Call<List<Country>>
}

object CountriesApi {
    val retrofitService : ApiServiceCountries by lazy {
        retrofit.create(ApiServiceCountries::class.java) }
}

/*
interface ApiServiceCountries {
    @GET("https://corona.lmao.ninja/v2/countries")
    fun fetchAllCountries(): Call<List<Country>>
    @GET("https://disease.sh/v3/covid-19/all")
    fun fetchTotalScores()
}
*/