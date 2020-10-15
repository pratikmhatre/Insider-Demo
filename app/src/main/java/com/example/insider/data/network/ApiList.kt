package com.example.insider.data.network

import com.example.insider.data.network.responses.EventsResponsePojo
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiList {
    @GET("/home?norm=1&filterBy=go-out")
    fun fetchEvents(@Query("city") city: String): Single<Response<EventsResponsePojo>>
}