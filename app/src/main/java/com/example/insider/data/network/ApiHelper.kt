package com.example.insider.data.network

import com.example.insider.data.network.responses.EventsResponsePojo
import io.reactivex.Single
import retrofit2.Response

interface ApiHelper {
    fun fetchEvents(city:String): Single<Response<EventsResponsePojo>>
}