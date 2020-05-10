package com.srokowski.pawelcv.retrofit.dto


import com.google.gson.annotations.SerializedName
import com.srokowski.pawelcv.retrofit.dto.skills.SkillsDto

data class CvDataDto(
    @SerializedName("address")
    val address: String?,
    @SerializedName("applications")
    val applications: List<ApplicationItemDto>?,
    @SerializedName("education")
    val education: List<EducationDto>?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("experience")
    val experience: List<ExperienceDto>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("occupation")
    val occupation: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("skills")
    val skills: SkillsDto?
)