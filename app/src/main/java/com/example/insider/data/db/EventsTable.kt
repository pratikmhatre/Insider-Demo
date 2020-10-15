package com.example.insider.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.insider.utils.AppConstants

@Entity(tableName = AppConstants.EVENTS_TABLE)
class EventsTable(
    @PrimaryKey(autoGenerate = true)
    var pk: Long? = null,
    var eventId: String?,
    var eventName: String?,
    var eventType: String?,
    var startTime: String?,
    var bannerImage: String?,
    var city: String?,
    var venueName: String?,
    var eventStatus: String?,
    var displayPrice: String?,
    var minPrice: String?,
    var groupName: String?,
    var categoryName: String?,
    var categoryColor: String?,
)