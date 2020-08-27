package com.example.covid_19.data.Repository

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TotalScoresDAO {
    @Query("SELECT * FROM TotalScoresEntity")
    fun getTotalScores(): LiveData<TotalScoresEntity>
    @Insert
    fun insert(totalScores: TotalScoresEntity)
    @Update
    fun update(totalScores: TotalScoresEntity)
    @Delete
    fun delete(totalScores: TotalScoresEntity)
}