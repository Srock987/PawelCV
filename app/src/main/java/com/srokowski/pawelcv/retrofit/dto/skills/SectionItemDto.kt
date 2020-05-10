package com.srokowski.pawelcv.retrofit.dto.skills


import com.google.gson.annotations.SerializedName

data class SectionItemDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("item")
    val item: String?
)