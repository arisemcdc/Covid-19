package com.example.covid_19.data

import androidx.lifecycle.MutableLiveData
import com.example.covid_19.data.Response.TotalScores
//import com.example.covid_19.data.Response.TotalScoresResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/*object remoteDataSource{
    val totalScoresLiveData = MutableLiveData<TotalScores>()

    fun refresh(){
        Covid19Api.retrofitService.getTotalCasesCall().enqueue(object:Callback<TotalScores>{
            override fun onFailure(call: Call<TotalScores>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<TotalScores>, response: Response<TotalScores>) {
                totalScoresLiveData.value = response.body()
            }
        })
    }*/
private const val BASE_URL = " https://corona.lmao.ninja"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface ApiServiceTotalScores {
    @GET("/v3/covid-19/all")
    suspend fun getTotalCases(): TotalScores
    @GET("/v3/covid-19/all")
    fun getTotalCasesCall(): Call<TotalScores>
    @GET("/v2/countries")
    suspend fun fetchAllCountries(): List<Country>
    @GET("/v2/countries/{countryId}")
    suspend fun getCountry(@Path("countryId")countryId: Int)
}
object Covid19Api {
    val retrofitService : ApiServiceTotalScores by lazy {
        retrofit.create(ApiServiceTotalScores::class.java) }
}



