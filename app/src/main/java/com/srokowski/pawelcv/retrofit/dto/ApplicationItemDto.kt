package com.srokowski.pawelcv.retrofit.dto


import com.google.gson.annotations.SerializedName

data class ApplicationItemDto(
    @SerializedName("appDescription")
    val appDescription: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("relation")
    val relation: String?,
    @SerializedName("url")
    val url: String?
)