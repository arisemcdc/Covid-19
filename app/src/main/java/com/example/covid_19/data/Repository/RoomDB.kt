package com.example.covid_19.data.Repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.covid_19.data.Country
import com.example.covid_19.data.Response.TotalScores

@Database(entities = [Country::class, TotalScores::class], version = 1)
abstract class RoomDB : RoomDatabase() {
    abstract fun countriesDao(): CountriesDAO
    abstract fun TotalScoresDAO(): TotalScoresDAO
}