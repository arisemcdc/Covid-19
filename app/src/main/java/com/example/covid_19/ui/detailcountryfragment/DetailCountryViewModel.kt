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
import com.example.covid_19.ui.Event

//import com.example.covid_19.data.Response.TotalScoresResponse

class DetailCountryViewModel : ViewModel() {
    //private val repository: Repository
    private var _countryId: String? = null

    private val _showToastLiveData =  MutableLiveData<Event<String>>()
    val showToastLiveData: LiveData<Event<String>> = _showToastLiveData

    val country = liveData {
        val rezult = Covid19App.repository.getCountriesScores(false)//DataResult<List<Country>>
       // val rezult = Covid19App.repository.localDB.countriesDao().getCountries()//List<Country>
        
        if (_countryId != null && rezult is DataResult.Success){
            if (rezult.isFromCache)
                _showToastLiveData.value = Event("Данные получены из кэша")
            val country = rezult.data.find { it.name == _countryId }
            if (country == null)
                throw Exception("cant find country with id=$_countryId")
            else
                emit(country)//Что значит emit ?

        }
        else
            emit(null)

        /*if (_countryId != null ){
            val country = rezult.find{it.name == _countryId}
            if (country == null)
                throw Exception("cant find country with id=$_countryId")
            else
                emit(country)//Что значит emit ?

        }
        else
            emit(null)*/


    }

    fun setCountryId(id: String){
        _countryId = id
    }
    /*private val _responseDetailCountry = MutableLiveData<Country>().apply {

    }
    val responseDetailCountry: LiveData<Country> = _responseDetailCountry*/


}