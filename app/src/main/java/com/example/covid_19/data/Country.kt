package com.example.covid_19.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(
    tableName = "Countries"
)
data class Country(
    @Embedded
    var info: CountryInfo,
    @PrimaryKey
    val id: Int = info._id,
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

data class CountryInfo(
   var _id:Int
)