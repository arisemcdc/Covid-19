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
    @Embedded()
    @SerializedName(value = "countryInfo")
    var info: CountryInfo,
    var cases: Int,
    @PrimaryKey
    @SerializedName(value = "country")
    var name: String,
    var deaths: Int,
    var population: Int,
    var recovered: Int,
    var tests: Int,
    var todayCases: Int,
    var todayDeaths: Int,
    var todayRecovered: Int
)

data class CountryInfo(
    var flag: String
)