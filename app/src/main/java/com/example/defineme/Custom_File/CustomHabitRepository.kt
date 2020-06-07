package com.example.defineme.Custom_File

import androidx.lifecycle.LiveData
import com.example.defineme.Custom_File.HabitDao
import com.example.defineme.Custom_File.custom

class CustomHabitRepository(private val habitDao: HabitDao) {

    val allHabits: LiveData<List<custom>> = habitDao.getAlphabetizedHabits()

    suspend fun insert(customHabit:custom){
        habitDao.insert(customHabit)
    }
}