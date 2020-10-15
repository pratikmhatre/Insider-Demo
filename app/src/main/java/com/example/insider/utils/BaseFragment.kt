package com.example.insider.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.insider.application.MyApplication
import com.example.insider.di.components.DaggerFragmentComponent
import com.example.insider.di.components.FragmentComponent
import com.example.insider.di.modules.FragmentModule

abstract class BaseFragment : Fragment() {
    lateinit var fragmentComponent: FragmentComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentComponent = DaggerFragmentComponent.builder()
            .appComponent(((activity?.application as MyApplication).getAppComponent()))
            .fragmentModule(
                FragmentModule()
            ).build()
    }
}