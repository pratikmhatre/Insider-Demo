package com.example.insider.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.insider.data.DataManager
import com.example.insider.data.DataManagerClass
import com.example.insider.data.db.MyDatabase
import com.example.insider.data.network.ApiList
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(val appContext: Context) {

    @Provides
    @Singleton
    fun getApiList(): ApiList {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.insider.in/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiList::class.java)
    }

    @Provides
    @Singleton
    fun provideSharedPrefs(): SharedPreferences {
        return appContext.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideDatabase(): MyDatabase {
        return Room.databaseBuilder(appContext, MyDatabase::class.java, "eventsDb")
            .build()
    }

    @Singleton
    @Provides
    fun provideDataManager(dataManagerClass: DataManagerClass): DataManager {
        return dataManagerClass
    }
}