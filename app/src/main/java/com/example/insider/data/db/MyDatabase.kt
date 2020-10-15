package com.example.insider.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EventsTable::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getEventsDao(): EventsTableDao
}