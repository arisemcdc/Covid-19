package com.example.covid_19.data

import com.example.covid_19.data.Response.TotalScoresResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = " https://corona.lmao.ninja"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/*interface ApiServiceTotalScores {
    @GET("cases")
    fun getTotalCases():
            Call<Int>
    @GET("deaths")
    fun getTotalDeaths():
            Call<Int>
    @GET("recovered")
    fun getTotalRecovered():
            Call<Int>
}*/
interface ApiServiceTotalScores {
    @GET("/v3/covid-19/all")
    fun getTotalCases():
            Call<TotalScoresResponse>
}
object TotalScoresApi {
    val retrofitService : ApiServiceTotalScores by lazy {
        retrofit.create(ApiServiceTotalScores::class.java) }
}

