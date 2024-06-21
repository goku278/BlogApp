package com.example.blog.model

import com.google.gson.annotations.SerializedName


data class VideoPictures(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("nr") var nr: Int? = null,
    @SerializedName("picture") var picture: String? = null

)
