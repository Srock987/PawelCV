package com.srokowski.pawelcv.retrofit.dto


import com.google.gson.annotations.SerializedName

data class EducationDto(
    @SerializedName("endDate")
    val endDate: Any?,
    @SerializedName("faculty")
    val faculty: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("university")
    val university: String?
)