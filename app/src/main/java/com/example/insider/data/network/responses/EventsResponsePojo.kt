package com.example.insider.data.network.responses

import com.google.gson.annotations.SerializedName

class EventsResponsePojo {
    var list: ListData? = null

    class ListData {
        var masterList: Map<String, Event>? = null

        class Event {
            @SerializedName("_id")
            var eventId: String? = null

            @SerializedName("venue_date_string")
            var startTime: String? = null

            var name: String? = null
            var type: String? = null

            @SerializedName("horizontal_cover_image")
            var bannerImage: String? = null

            var city: String? = null

            @SerializedName("venue_name")
            var venueName: String? = null

            @SerializedName("event_state")
            var eventStatus: String? = null

            @SerializedName("price_display_string")
            var displayPrice: String? = null

            @SerializedName("min_price")
            var minPrice: String? = null

            @SerializedName("group_id")
            var groupMeta: Generic? = null

            @SerializedName("category_id")
            var categoryMeta: Generic? = null

            class Generic {
                var name: String? = null

                @SerializedName("display_details")
                var displayDetails: DisplayDetails? = null

                class DisplayDetails {
                    var colour: String? = null
                }
            }

        }
    }
}