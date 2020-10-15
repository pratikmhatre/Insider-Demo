package com.example.insider.utils

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.insider.application.MyApplication
import com.example.insider.di.components.ActivityComponent
import com.example.insider.di.components.DaggerActivityComponent
import com.example.insider.di.modules.ActivityModule

abstract class BaseActivity : AppCompatActivity() {
    lateinit var activityComponent: ActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((application as MyApplication).getAppComponent()).activityModule(
                ActivityModule(this)
            ).build()
    }

    fun showToast(msg: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, msg, length).show()
    }
}