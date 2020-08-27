package com.example.covid_19.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covid_19.data.Response.TotalScoresResponse
import com.example.covid_19.data.TotalScoresApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _responseTotalCases = MutableLiveData<TotalScoresResponse>().apply {

    }
    val responseTotalCases: LiveData<TotalScoresResponse> = _responseTotalCases
    /*private val _responseTotalDeaths = MutableLiveData<Int>().apply {
        value = 0
    }
    val responseTotalDeaths: LiveData<Int> = _responseTotalDeaths
    private val _responseTotalRecovered = MutableLiveData<Int>().apply {
        value = 0
    }
    val responseTotalRecovered: LiveData<Int> = _responseTotalRecovered
*/
    init {
        getTotalScores()
    }
    private fun getTotalScores() {
        TotalScoresApi.retrofitService.getTotalCases().enqueue(
            object: Callback<TotalScoresResponse> {
                override fun onFailure(call: Call<TotalScoresResponse>, t: Throwable) {

                }

                override fun onResponse(call: Call<TotalScoresResponse>, response: Response<TotalScoresResponse>) {
                    _responseTotalCases.value = response.body()
                }
            })
        /*TotalScoresApi.retrofitService.getTotalDeaths().enqueue(
            object: Callback<Int> {
                override fun onFailure(call: Call<Int>, t: Throwable) {
                    _responseTotalDeaths.value = 0
                }

                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    _responseTotalDeaths.value = response.body()
                }
            })
        TotalScoresApi.retrofitService.getTotalRecovered().enqueue(
            object: Callback<Int> {
                override fun onFailure(call: Call<Int>, t: Throwable) {
                    _responseTotalRecovered.value =  0
                }

                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    _responseTotalRecovered.value = response.body()
                }
            })*/
    }
}