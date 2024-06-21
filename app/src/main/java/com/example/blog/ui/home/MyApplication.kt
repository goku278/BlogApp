package com.example.blog.ui.home

import android.app.Application
import com.example.blog.di.ApplicationComponent
import com.example.blog.di.DaggerApplicationComponent
import com.example.blog.di.NetworkModule

class MyApplication : Application() {
    private lateinit var retroComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerApplicationComponent.builder()
            .networkModule(NetworkModule(this))
            .build()

    }

    fun getRetroComponent(): ApplicationComponent {
        return retroComponent
    }
    // DaggerApplicationComponent
}