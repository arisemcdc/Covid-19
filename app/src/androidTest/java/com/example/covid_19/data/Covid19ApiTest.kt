package com.example.covid_19.data

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Covid19ApiTest : TestCase() {
    @Test
    fun getCountries() = runBlocking {
        val data = Covid19Api.retrofitService.getTotalCases()
        Log.d("myLog", data.toString())
     Unit
    }
    @Test
    fun fetchAllCountries() = runBlocking {
        val data =Covid19Api.retrofitService.fetchAllCountries()
        Log.d("myLog", data.toString())
        Unit
    }
}