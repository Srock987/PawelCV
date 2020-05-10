package com.srokowski.pawelcv.retrofit.dto.skills


import com.google.gson.annotations.SerializedName

data class ProgrammingSkillDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("skillName")
    val skillName: String?,
    @SerializedName("skillProficiency")
    val skillProficiency: String?
)