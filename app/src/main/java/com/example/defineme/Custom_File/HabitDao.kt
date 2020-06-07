package com.example.defineme.Custom_File

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao

interface HabitDao {

    @Query("SELECT * from NewHabits ORDER BY customHabit ASC")
    fun getAlphabetizedHabits():LiveData<List<custom>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(customHabit: custom)

    @Query("DELETE from Newhabits")
    suspend fun deleteAll()
}