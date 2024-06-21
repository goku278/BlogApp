package com.example.blog.di

import android.content.Context
import com.example.blog.network.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(private val context: Context) {
    private val BASE_URL = "https://api.pexels.com/v1/"

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        // Create a Retrofit instance
        return Retrofit.Builder()
            .baseUrl(BASE_URL) // Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create()) // Add a converter factory (e.g., Gson)
            .build()
    }
}