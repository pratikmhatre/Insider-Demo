package com.example.insider.screens.splash.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.insider.databinding.FragEventsBinding
import com.example.insider.screens.splash.SplashActivity
import com.example.insider.utils.BaseFragment
import javax.inject.Inject

class EventsFragment : BaseFragment() {
    @Inject
    lateinit var eventsAdapter: EventsListAdapter
    private lateinit var rootBinding: FragEventsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentComponent.inject(this)
        val eventList = (activity as SplashActivity).eventsList

        val groupName = arguments?.getString("group")
        groupName?.run {
            if (this.equals("all events", ignoreCase = true)) {
                eventsAdapter.addEvents(eventList)
            } else {
                eventsAdapter.addEvents(eventList.filter {
                    it.groupName.equals(this, ignoreCase = true)
                })
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootBinding = FragEventsBinding.inflate(inflater, container, false)

        rootBinding.recyclerEvents.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        return rootBinding.root
    }
}