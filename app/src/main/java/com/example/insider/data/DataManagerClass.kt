package com.example.insider.data

import com.example.insider.data.db.DbHelperClass
import com.example.insider.data.db.EventsTable
import com.example.insider.data.network.ApiHelperClass
import javax.inject.Inject

class DataManagerClass @Inject constructor(
    var apiHelper: ApiHelperClass,
    val dbHelperClass: DbHelperClass
) : DataManager {
    override fun fetchEvents(city: String) = apiHelper.fetchEvents(city)

    override fun getAllEvents() = dbHelperClass.getAllEvents()
    override fun deleteAllEvents() = dbHelperClass.deleteAllEvents()
    override fun insertEvents(events: List<EventsTable>) = dbHelperClass.insertEvents(events)
}