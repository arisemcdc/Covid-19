package com.example.covid_19.data.Repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.covid_19.data.Response.TotalScores

@Dao
interface TotalScoresDAO {
    @Query("SELECT * FROM TotalScores")
    fun getTotalScoresLiveData(): LiveData<List<TotalScores>>
    @Query("SELECT * FROM TotalScores")
    suspend fun getTotalScores(): List<TotalScores>
    @Insert
    suspend fun insert(totalScores: TotalScores)
    @Update
    suspend fun update(totalScores: TotalScores)
    @Delete
    suspend fun delete(totalScores: TotalScores)
    @Query("DELETE FROM TotalScores")
    suspend fun deleteAll()
}