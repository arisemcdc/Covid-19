package com.example.covid_19.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "Countries"
)
data class Country(
    @PrimaryKey
    var id:String = UUID.randomUUID().toString(),
    var cases: Int,
    var country: String,
    var deaths: Int,
    var population: Int,
    var recovered: Int,
    var tests: Int,
    var todayCases: Int,
    var todayDeaths: Int,
    var todayRecovered: Int
)