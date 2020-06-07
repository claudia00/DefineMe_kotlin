package com.example.defineme.Custom_File

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomHabitViewModel(application: Application): AndroidViewModel(application) {

    private val repository: CustomHabitRepository

    val allHabits: LiveData<List<custom>>

    init{
        val habitsDao = CustomHabitRoomDatabase.getDatabase(application, viewModelScope).habitDao()
        repository =
            CustomHabitRepository(habitsDao)
        allHabits = repository.allHabits
    }

    fun insert(customHabit: custom) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(customHabit)
    }

}