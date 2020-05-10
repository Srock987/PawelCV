package com.srokowski.pawelcv.retrofit.dto


import com.google.gson.annotations.SerializedName

data class ExperienceDto(
    @SerializedName("company")
    val company: String?,
    @SerializedName("endDate")
    val endDate: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("jobDescription")
    val jobDescription: String?,
    @SerializedName("jobTitle")
    val jobTitle: String?,
    @SerializedName("startDate")
    val startDate: String?
)