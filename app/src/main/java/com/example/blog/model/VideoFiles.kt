package com.example.blog.model

import com.google.gson.annotations.SerializedName


data class VideoFiles(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("quality") var quality: String? = null,
    @SerializedName("file_type") var fileType: String? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("fps") var fps: Double? = null,
    @SerializedName("link") var link: String? = null,
    @SerializedName("size") var size: Int? = null,
    var thumbNails: String? = null
)