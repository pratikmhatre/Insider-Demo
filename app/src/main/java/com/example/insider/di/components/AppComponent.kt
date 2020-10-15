package com.example.insider.di.components

import com.example.insider.data.DataManager
import com.example.insider.data.network.ApiList
import com.example.insider.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun provideDataManager(): DataManager
    fun provideApiList(): ApiList
}