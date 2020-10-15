package com.example.insider.screens.splash.frags

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.insider.data.db.EventsTable
import com.example.insider.databinding.ItemEventBinding

class EventsListAdapter : RecyclerView.Adapter<EventsListAdapter.EventHolder>() {
    private val eventsList = ArrayList<EventsTable>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val rootBinding =
            ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventHolder(rootBinding)
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) =
        holder.bindEvent(eventsList[position])

    override fun getItemCount() = eventsList.size

    class EventHolder(val itemEventBinding: ItemEventBinding) :
        RecyclerView.ViewHolder(itemEventBinding.root) {
        fun bindEvent(eventsTable: EventsTable) {
            itemEventBinding.apply {
                title = eventsTable.eventName
                category = eventsTable.categoryName
                price = "Rs.${eventsTable.displayPrice}"
                source = eventsTable.venueName
                dateTime = eventsTable.startTime

                ivBanner.setImageURI(eventsTable.bannerImage)

                eventsTable.categoryColor?.run {
                    tvCategory.backgroundTintList = ColorStateList.valueOf(Color.parseColor(eventsTable.categoryColor))
                }
            }
        }
    }
    fun addEvents(eventList: List<EventsTable>) {
        this.eventsList.clear()
        this.eventsList.addAll(eventList)
        notifyDataSetChanged()
    }
}