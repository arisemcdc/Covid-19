package com.example.covid_19.ui.detailcountryfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.navigation.fragment.navArgs
import com.example.covid_19.Covid19App
import com.example.covid_19.data.Country
import com.example.covid_19.data.DataResult
import com.example.covid_19.data.Repository.Repository
import com.example.covid_19.data.Repository.RoomDB

//import com.example.covid_19.data.Response.TotalScoresResponse

class DetailCountryViewModel : ViewModel() {
    //private val repository: Repository
    private var _countryId: String? = null

    val country = liveData {
        val rezult = Covid19App.repository.getCountriesScores(false)
        if (_countryId != null && rezult is DataResult.Success){
            val country = rezult.data.find{it.name == _countryId}
            if (country == null) 
                throw Exception("cant find country with id=$_countryId")
            else
                emit(country)

        }
        else
            emit(null)
    }

    fun setCountryId(id: String){
        _countryId = id
    }
    /*private val _responseDetailCountry = MutableLiveData<Country>().apply {

    }
    val responseDetailCountry: LiveData<Country> = _responseDetailCountry*/


}