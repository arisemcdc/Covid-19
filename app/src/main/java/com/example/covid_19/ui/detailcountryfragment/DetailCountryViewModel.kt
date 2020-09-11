package com.example.covid_19.ui.detailcountryfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.example.covid_19.data.Country
import com.example.covid_19.data.Repository.Repository
import com.example.covid_19.data.Repository.RoomDB

//import com.example.covid_19.data.Response.TotalScoresResponse

class DetailCountryViewModel : ViewModel() {
    val args: DetailCountryFragmentArgs by navArgs()
    val tempCountry = Repository.localDB.countriesDao().getCountriesLiveData.value?.find { args.countryId== it.id }

    /*private val _responseDetailCountry = MutableLiveData<Country>().apply {

    }
    val responseDetailCountry: LiveData<Country> = _responseDetailCountry*/


}