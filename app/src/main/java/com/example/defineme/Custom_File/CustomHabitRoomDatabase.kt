package com.example.defineme.Custom_File

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(custom::class), version = 1, exportSchema = false)
public abstract class CustomHabitRoomDatabase : RoomDatabase() {

    abstract fun habitDao(): HabitDao

    private class CustomHabitDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback(){

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let{ database ->
                scope.launch {
                    var habitDao = database.habitDao()
                    habitDao.deleteAll()

                    var customHabit = custom("Habit 1")
                    habitDao.insert(customHabit)
                }
            }
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: CustomHabitRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): CustomHabitRoomDatabase {
//        val tempInstance = INSTANCE
//        if (tempInstance != null) {
//            return tempInstance
//        }
            return INSTANCE ?:
        synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                CustomHabitRoomDatabase::class.java,
                "customHabitDatabase"
            )
                .addCallback(CustomHabitDatabaseCallback(scope))
                .build()
            INSTANCE = instance
            //return instance
            instance
        }
    }
}
}