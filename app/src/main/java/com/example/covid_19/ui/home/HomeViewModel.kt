package com.example.covid_19.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.covid_19.data.Covid19Api
import com.example.covid_19.data.DataResult
import com.example.covid_19.data.Response.TotalScoresResponse
/*import com.example.covid_19.data.TotalScoresApi */
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val totalScores = LiveData {
        val data = Covid19Api.repository.getTotalScore()
        emit(data)
    }
    val cases = Transformations.map(totalScores) {
        if (it is DataResult.Success) it.data.cases.toString()
        else
            "Error"
    }
    val deaths = Transformations.map(totalScores) {
        if (it is DataResult.Success) it.data.deaths.toString()
        else
            "Error"
    }
    val recovered = Transformations.map(totalScores) {
        if (it is DataResult.Success) it.data.recovered.toString()
        else
            "Error"
    }
}