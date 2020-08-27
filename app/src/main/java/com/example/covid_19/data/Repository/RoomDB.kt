package com.example.covid_19.data.Repository

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [CountryEntity::class, TotalScoresEntity::class], version = 1)
abstract class RoomDB : RoomDatabase() {
    abstract fun countriesDao(): CountriesDAO
    abstract fun TotalScoresDAO(): TotalScoresDAO
}