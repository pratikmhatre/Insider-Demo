package com.example.insider.di.components

import com.example.insider.di.annotations.PerActivity
import com.example.insider.di.modules.FragmentModule
import com.example.insider.screens.splash.frags.EventsFragment
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {
    fun inject(eventsFragment: EventsFragment)
}