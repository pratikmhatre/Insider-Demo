package com.example.insider.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.insider.utils.AppConstants

@Dao
interface EventsTableDao {
    @Query("select * from ${AppConstants.EVENTS_TABLE}")
    fun getAllEvents(): LiveData<List<EventsTable>>

    @Insert
    fun insertEvents(events: List<EventsTable>)

    @Query("delete from ${AppConstants.EVENTS_TABLE}")
    fun deleteAllEvents()
}