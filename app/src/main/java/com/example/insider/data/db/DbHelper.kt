package com.example.insider.data.db

import androidx.lifecycle.LiveData

interface DbHelper {
    fun getAllEvents(): LiveData<List<EventsTable>>
    fun insertEvents(events: List<EventsTable>)
    fun deleteAllEvents()
}