package com.example.insider.data.network

import javax.inject.Inject

class ApiHelperClass @Inject constructor(val apiList: ApiList) : ApiHelper {
    override fun fetchEvents(city: String) = apiList.fetchEvents(city)
}