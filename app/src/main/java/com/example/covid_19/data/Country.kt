package com.example.covid_19.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/*
@Entity(tableName = "countries")
data class CountryName(val name:String ="", @PrimaryKey val id: String = UUID.randomUUID().toString())
@Entity(tableName = "ills")
data class Ills(val score:Int = 0, @PrimaryKey val id: String = UUID.randomUUID().toString())
data class Country(
    val countryname: CountryName = CountryName(),
    val ills: Ills = Ills(),
    val id: String = UUID.randomUUID().toString()
)*/


/*data class CountryName(val name:String)
data class Ills(val score:Int)*/
data class Country(
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