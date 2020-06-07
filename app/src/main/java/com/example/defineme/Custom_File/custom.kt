package com.example.defineme.Custom_File

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NewHabits")

class custom(
    @PrimaryKey
    @ColumnInfo(name = "customHabit") val customHabit: String

)
