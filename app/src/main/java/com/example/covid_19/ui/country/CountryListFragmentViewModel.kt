package com.example.covid_19.ui.country

import androidx.lifecycle.*
import com.example.covid_19.Covid19App
/*import com.example.covid_19.data.CountriesApi*/
import com.example.covid_19.data.Country
import com.example.covid_19.data.DataResult
import retrofit2.Call
import retrofit2.Response

class CountryListFragmentViewModel : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    val countries = liveData {
        _isLoading.value = true
        val data = Covid19App.repository.getCountriesScores()
        emit(data)
        _isLoading.value = false
    }
    val  countriesList = Transformations.map(countries) {
        if (it is DataResult.Success) it.data
        else
            "Error"
    }

   /* val cases = Transformations.map(totalScores) {
        if (it is DataResult.Success) it.data.cases.toString()
        else
            "Error"
    }*/

}