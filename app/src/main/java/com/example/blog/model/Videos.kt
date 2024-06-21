package com.example.blog.model

import com.example.blog.model.User
import com.example.blog.model.VideoFiles
import com.example.blog.model.VideoPictures
import com.google.gson.annotations.SerializedName


data class Videos(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("duration") var duration: Int? = null,
    @SerializedName("full_res") var fullRes: String? = null,
    @SerializedName("tags") var tags: ArrayList<String> = arrayListOf(),
    @SerializedName("url") var url: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("avg_color") var avgColor: String? = null,
    @SerializedName("user") var user: User? = User(),
    @SerializedName("video_files") var videoFiles: ArrayList<VideoFiles> = arrayListOf(),
    @SerializedName("video_pictures") var videoPictures: ArrayList<VideoPictures> = arrayListOf()

)