package com.example.insider.di.components

import com.example.insider.di.annotations.PerActivity
import com.example.insider.di.modules.ActivityModule
import com.example.insider.screens.splash.SplashActivity
import dagger.Component

@PerActivity
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {
    fun inject(splashActivity: SplashActivity)
}