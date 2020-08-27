package com.example.covid_19.data.Repository

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "TotalScoresEntity"
)
data class TotalScoresEntity(
    @PrimaryKey
    var id:String = UUID.randomUUID().toString(),
    var active: Int,
    var activePerOneMillion: Double,
    var affectedCountries: Int,
    var cases: Int,
    var casesPerOneMillion: Int,
    var critical: Int,
    var criticalPerOneMillion: Double,
    var deaths: Int,
    var deathsPerOneMillion: Int,
    var oneCasePerPeople: Int,
    var oneDeathPerPeople: Int,
    var oneTestPerPeople: Int,
    var population: Long,
    var recovered: Int,
    var recoveredPerOneMillion: Double,
    var tests: Int,
    var testsPerOneMillion: Double,
    var todayCases: Int,
    var todayDeaths: Int,
    var todayRecovered: Int,
    var updated: Long
)