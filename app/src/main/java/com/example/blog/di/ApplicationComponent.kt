package com.example.blog.di

import com.example.blog.di.NetworkModule
import com.example.blog.ui.home.BlogViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(blogViewModel: BlogViewModel)
}