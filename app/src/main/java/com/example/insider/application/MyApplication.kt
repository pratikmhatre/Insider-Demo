package com.example.insider.application

import android.app.Application
import com.example.insider.di.components.AppComponent
import com.example.insider.di.components.DaggerAppComponent
import com.example.insider.di.modules.AppModule
import com.facebook.drawee.backends.pipeline.Fresco

class MyApplication : Application() {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        Fresco.initialize(this)
    }

    fun getAppComponent() = appComponent
}