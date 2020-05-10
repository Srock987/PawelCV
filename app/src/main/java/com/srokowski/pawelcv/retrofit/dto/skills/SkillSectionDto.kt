package com.srokowski.pawelcv.retrofit.dto.skills


import com.google.gson.annotations.SerializedName

data class SkillSectionDto(
    @SerializedName("sectionId")
    val sectionId: Int?,
    @SerializedName("sectionItems")
    val sectionItems: List<SkillSectionItemDto>?,
    @SerializedName("sectionName")
    val sectionName: String?
)