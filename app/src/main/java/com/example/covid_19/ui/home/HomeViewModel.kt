package com.example.covid_19.ui.home

import androidx.lifecycle.*
import com.example.covid_19.Covid19App
import com.example.covid_19.data.Covid19Api
import com.example.covid_19.data.DataResult
//import com.example.covid_19.data.Response.TotalScoresResponse
import kotlinx.coroutines.delay
/*import com.example.covid_19.data.TotalScoresApi */
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading


    val totalScores = liveData {
        _isLoading.value = true
        delay(5000)
        val data = Covid19App.repository.getTotalScore()
        emit(data)// Что это означает?
        _isLoading.value = false
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