package com.example.blog.model

import com.google.gson.annotations.SerializedName

data class VideoData(

    @SerializedName("page") var page: Int? = null,
    @SerializedName("per_page") var perPage: Int? = null,
    @SerializedName("videos") var videos: ArrayList<Videos> = arrayListOf(),
    @SerializedName("total_results") var totalResults: Int? = null,
    @SerializedName("next_page") var nextPage: String? = null,
    @SerializedName("url") var url: String? = null

)