package com.srokowski.pawelcv.retrofit.dto.skills


import com.google.gson.annotations.SerializedName

data class SectionDto(
    @SerializedName("sectionId")
    val sectionId: Int?,
    @SerializedName("sectionItems")
    val sectionItems: List<SectionItemDto>?,
    @SerializedName("sectionName")
    val sectionName: String?
)