package com.example.insider.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.insider.screens.splash.SplashFactory
import com.example.insider.screens.splash.SplashViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activityContext: AppCompatActivity) {
    @Provides
    fun provideSplashViewModel(factory: SplashFactory): SplashViewModel {
        return ViewModelProvider(activityContext, factory)[SplashViewModel::class.java]
    }
}