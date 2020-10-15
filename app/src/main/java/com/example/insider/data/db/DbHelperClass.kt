package com.example.insider.data.db

import javax.inject.Inject

class DbHelperClass @Inject constructor(val myDatabase: MyDatabase) : DbHelper {
    override fun getAllEvents() = myDatabase.getEventsDao().getAllEvents()
    override fun deleteAllEvents() = myDatabase.getEventsDao().deleteAllEvents()
    override fun insertEvents(events: List<EventsTable>) = myDatabase.getEventsDao().insertEvents(events)
}