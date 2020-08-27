package com.example.covid_19.data.Repository

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CountriesDAO {
    @Query("SELECT * FROM countries")
    fun getCountries(): LiveData<List<CountryEntity>>
    @Insert
    fun insert(country: CountryEntity)
    @Update
    fun update(country: CountryEntity)
    @Delete
    fun delete(country: CountryEntity)
}