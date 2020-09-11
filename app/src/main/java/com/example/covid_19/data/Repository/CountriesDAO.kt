package com.example.covid_19.data.Repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.covid_19.data.Country

@Dao
interface CountriesDAO {
    @Query("SELECT * FROM Countries")
    fun getCountriesLiveData(): LiveData<List<Country>>
    @Query("SELECT * FROM Countries")
    suspend fun getCountries(): List<Country>
    @Insert
    suspend fun insert(countries: List<Country>)
    @Update
    suspend fun update(country: Country)
    @Delete
    suspend fun delete(country: Country)
}