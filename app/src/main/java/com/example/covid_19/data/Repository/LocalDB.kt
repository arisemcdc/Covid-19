package com.example.covid_19.data.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.covid_19.data.Country
import com.example.covid_19.data.Response.TotalScores
//import com.example.covid_19.data.Response.TotalScoresResponse

class LocalDB(private val roomDB: RoomDB) {
    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries
    private val _totalScores = MutableLiveData<TotalScores>()
    val totalScores: LiveData<TotalScores> = _totalScores
    /*fun insertCountry(country: Country) = roomDB.countriesDao().insert(countrytoCountryEntity(country))*/
    /*private fun countrytoCountryEntity(country: Country): CountryEntity {
        val countryEntity = CountryEntity()
        countryEntity.id = country.id
        countryEntity.cases = country.cases
        countryEntity.deaths = country.deaths
        countryEntity.population = country.population
        countryEntity.recovered = country.recovered
        countryEntity.tests = country.tests
        countryEntity.todayCases = country.todayCases
        countryEntity.todayRecovered = country.todayRecovered
        return countryEntity
    }
    private fun totalScorestoTotalScoresEntity(totalScores:TotalScoresResponse): TotalScoresEntity {
        val totalScoresEntity = TotalScoresEntity()
        totalScoresEntity.id = totalScores.id
        totalScoresEntity.active = totalScores.active
        totalScoresEntity.activePerOneMillion = totalScores.activePerOneMillion
        totalScoresEntity.affectedCountries = totalScores.affectedCountries
        totalScoresEntity.cases = totalScores.cases
        totalScoresEntity.casesPerOneMillion = totalScores.casesPerOneMillion
        totalScoresEntity.critical = totalScores.critical
        totalScoresEntity.criticalPerOneMillion = totalScores.criticalPerOneMillion
        totalScoresEntity.deaths = totalScores.deaths
        totalScoresEntity.deathsPerOneMillion = totalScores.deathsPerOneMillion
        totalScoresEntity.oneCasePerPeople = totalScores.oneCasePerPeople
        totalScoresEntity.oneDeathPerPeople = totalScores.oneDeathPerPeople
        totalScoresEntity.oneTestPerPeople = totalScores.oneTestPerPeople
        totalScoresEntity.population = totalScores.population
        totalScoresEntity.recovered = totalScores.recovered
        totalScoresEntity.recoveredPerOneMillion = totalScores.recoveredPerOneMillion
        totalScoresEntity.tests = totalScores.tests
        totalScoresEntity.testsPerOneMillion = totalScores.testsPerOneMillion
        totalScoresEntity.todayCases = totalScores.todayCases
        totalScoresEntity.todayDeaths = totalScores.todayDeaths
        totalScoresEntity.todayRecovered = totalScores.todayRecovered
        totalScoresEntity.updated = totalScores.updated
        return totalScoresEntity
    }
    private fun countryEntityToCountry(countryEntity: CountryEntity): Country {
        return Country(
            roomDB.countriesDao().getCountries().find { it.id ==  countryEntity.id} ?: throw IllegalArgumentException()
        )
    }
}
private fun totalScoresEntitytoTotalScores(totalScoresEntity: TotalScoresEntity): TotalScoresResponse {
    return TotalScoresResponse(
        roomDB.TotalScoresDAO().getTotalScores().find{it.id ==  TotalScoresEntity.id}
    )
}
}*/
}