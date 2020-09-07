package com.example.covid_19.data

import android.util.Log
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class Covid19ApiTest : TestCase() {
    @Test
    fun getCountries() = runBlocking {
        val data = Covid19Api.retrofitService.getTotalCases()
        Log.d("myLog", data.toString())
     Unit
    }
}