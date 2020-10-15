package com.example.insider.di.modules

import com.example.insider.screens.splash.frags.EventsListAdapter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {
    @Provides
    fun provideEventsAdapter() = EventsListAdapter()
}