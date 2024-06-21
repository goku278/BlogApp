package com.example.blog.util

import android.content.Context
import android.content.SharedPreferences
import com.example.blog.model.Photos
import com.example.blog.model.VideoFiles
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPreferencesHelper(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()
    fun savePhotos(photos: List<Photos>, key: String) {
        val json = gson.toJson(photos)
        prefs.edit().putString(key, json).apply()
    }
    fun getPhotos(key: String): List<Photos>? {
        val json = prefs.getString(key, null)
        return if (json != null) {
            gson.fromJson(json, object : TypeToken<List<Photos>>() {}.type)
        } else {
            null
        }
    }
    // Save VideoFiles object
    fun saveVideoFiles(videoFiles: List<VideoFiles>, key: String) {
        val json = gson.toJson(videoFiles)
        prefs.edit().putString(key, json).apply()
    }
    // Retrieve VideoFiles object
    fun getVideoFiles(key: String): List<VideoFiles>? {
        val json = prefs.getString(key, null)
        return if (json != null) {
            gson.fromJson(json, object : TypeToken<List<VideoFiles>>() {}.type)
        } else {
            null
        }
    }
}