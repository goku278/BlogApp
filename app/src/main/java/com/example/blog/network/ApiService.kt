package com.example.blog.network

import com.example.blog.model.Images
import com.example.blog.model.VideoData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization: yj2VBmep7AF7DYvxju9vefY2i3Bnp30xuRq3jEihzIuqhffu3L1CQ8pD")
    @GET("curated?page=2&per_page=25")
    fun getCuratedImages(): Call<Images>

 /*   @Headers("Authorization: yj2VBmep7AF7DYvxju9vefY2i3Bnp30xuRq3jEihzIuqhffu3L1CQ8pD")
    @GET("v1/curated")
    fun getCuratedImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<Images>*/

/*    @Headers("Authorization: yj2VBmep7AF7DYvxju9vefY2i3Bnp30xuRq3jEihzIuqhffu3L1CQ8pD")
    @GET("v1/curated")
    fun getCuratedImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<Images>*/

    @Headers("Authorization: yj2VBmep7AF7DYvxju9vefY2i3Bnp30xuRq3jEihzIuqhffu3L1CQ8pD")
    @GET("videos/search")
    fun getVideos(
        @Query("query") query: String,
        @Query("per_page") perPage: Int
    ): Call<VideoData>
}
