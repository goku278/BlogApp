package com.example.blog.model

import com.example.blog.model.Photos
import com.google.gson.annotations.SerializedName


data class Images(

    @SerializedName("page") var page: Int? = null,
    @SerializedName("per_page") var perPage: Int? = null,
    @SerializedName("photos") var photos: ArrayList<Photos> = arrayListOf(),
    @SerializedName("total_results") var totalResults: Int? = null,
    @SerializedName("next_page") var nextPage: String? = null,
    @SerializedName("prev_page") var prevPage: String? = null

)