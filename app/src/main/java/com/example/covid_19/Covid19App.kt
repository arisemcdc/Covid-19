package com.example.covid_19

import android.app.Application
import androidx.room.Room
import com.example.covid_19.data.Repository.Repository
import com.example.covid_19.data.Repository.RoomDB


class Covid19App: Application() {
    companion object {
        lateinit var repository: Repository
    }
    override fun onCreate() {
        super.onCreate()
        val db = Room.databaseBuilder(applicationContext, RoomDB::class.java, "db").build()
        repository = Repository(db)
    }
}
