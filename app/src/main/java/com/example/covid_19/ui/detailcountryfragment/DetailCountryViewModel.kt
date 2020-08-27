package com.example.covid_19.ui.detailcountryfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covid_19.data.Country
import com.example.covid_19.data.Response.TotalScoresResponse

class DetailCountryViewModel : ViewModel() {
    private val _responseDetailCountry = MutableLiveData<Country>().apply {

    }
    val responseDetailCountry: LiveData<Country> = _responseDetailCountry


}