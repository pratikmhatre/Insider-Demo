package com.example.insider.screens.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import com.example.insider.data.db.EventsTable
import com.example.insider.databinding.ActivitySplashBinding
import com.example.insider.screens.splash.frags.EventsFragment
import com.example.insider.utils.AppFunction
import com.example.insider.utils.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {
    private lateinit var activityBinding: ActivitySplashBinding
    lateinit var eventsList: List<EventsTable>

    @Inject
    lateinit var splashViewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        activityBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        if (AppFunction.isConnectedToInternet(this)) {
            splashViewModel.fetchEvents()
        }
        setupObserver()
    }

    private fun setupObserver() {
        splashViewModel.getAllEventsFromDb().observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                eventsList = it
                setupViewPager()
            }
        })
    }

    private fun setupViewPager() {
        val grouped = eventsList.groupBy {
            it.groupName
        }
        val titles = ArrayList<String>()
        titles.add("All Events")
        grouped.keys.forEach {
            it?.run {
                titles.add(this)
            }
        }

        with(activityBinding) {
            viewPager.adapter = EventsPagerAdapter(supportFragmentManager, titles)
            tabLayout.setupWithViewPager(viewPager)
        }
    }

    private class EventsPagerAdapter(fragmentManager: FragmentManager, val titles: List<String>) :
        FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getCount() = titles.size
        override fun getPageTitle(position: Int) = titles[position]
        override fun getItem(position: Int): Fragment {
            val bundle = Bundle()
            bundle.putString("group", titles[position])
            val frag = EventsFragment()
            frag.arguments = bundle
            return frag
        }
    }
}