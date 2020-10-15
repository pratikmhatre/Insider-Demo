package com.example.insider.screens.splash

import com.example.insider.data.DataManager
import com.example.insider.data.db.EventsTable
import com.example.insider.data.network.responses.EventsResponsePojo
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class SplashRepository @Inject constructor(val dataManager: DataManager) {
    val scope = CoroutineScope(Dispatchers.Default)
    fun getEventsFromDb() = dataManager.getAllEvents()

    fun deleteDbEvents() {
        scope.launch {
            dataManager.deleteAllEvents()
        }
    }

    fun fetchEvents() {
        dataManager.fetchEvents("mumbai").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<EventsResponsePojo>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onSuccess(t: Response<EventsResponsePojo>) {
                    if (t.code() == 200 && t.body()?.list?.masterList != null && t.body()?.list?.masterList!!.isNotEmpty()) {
                        scope.launch {
                            dataManager.deleteAllEvents()
                            val eventTableList = t.body()?.list?.masterList!!.map {
                                val table = it.value.toTable()
                                table
                            }
                            dataManager.insertEvents(eventTableList)
                        }
                    }
                }

                override fun onError(e: Throwable) {
                }
            })
    }

    private fun EventsResponsePojo.ListData.Event.toTable() = EventsTable(
        eventId = eventId,
        bannerImage = bannerImage,
        city = city,
        displayPrice = displayPrice,
        eventName = name,
        eventStatus = eventStatus,
        eventType = type,
        groupName = groupMeta?.name,
        minPrice = minPrice,
        startTime = startTime,
        venueName = venueName,
        categoryName = categoryMeta?.name,
        categoryColor = categoryMeta?.displayDetails?.colour
    )
}