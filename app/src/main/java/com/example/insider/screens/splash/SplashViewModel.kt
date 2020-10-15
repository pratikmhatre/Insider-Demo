package com.example.insider.screens.splash

import androidx.lifecycle.ViewModel

class SplashViewModel(private val repository: SplashRepository) : ViewModel() {
    fun fetchEvents() {
        repository.deleteDbEvents()
        repository.fetchEvents()
    }

    fun getAllEventsFromDb() = repository.getEventsFromDb()
}