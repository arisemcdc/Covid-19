package com.example.covid_19.ui.country

import androidx.lifecycle.*
import com.example.covid_19.Covid19App
/*import com.example.covid_19.data.CountriesApi*/
import com.example.covid_19.data.Country
import com.example.covid_19.data.DataResult
import kotlinx.coroutines.launch
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
    
/*    init{
        viewModelScope.launch{
            _isLoading.value = true
            val data = Covid19App.repository.getCountriesScores()
            countriesLiveData.value = data
            _isLoading.value = false
        }
    }
    val countriesLiveData= MutableLiveData<DataResult<List<Country>>>()*/


    val countriesList = Transformations.map(countries) {
        if (it is DataResult.Success)
            it.data
        else
            null
    }
//livedata для recyclerView
    val error = Transformations.map(countries){
        if (it is DataResult.Error)
            "Error!"
        else
            null // а зачем тут оборабаывать null , если когда у нас не DaraResult.Error, то Success?
    }
// livedata для textView
   /* val cases = Transformations.map(totalScores) {
        if (it is DataResult.Success) it.data.cases.toString()
        else
            "Error"
    }*/

}