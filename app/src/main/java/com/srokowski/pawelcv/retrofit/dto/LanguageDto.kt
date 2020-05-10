package com.srokowski.pawelcv.retrofit.dto


import com.google.gson.annotations.SerializedName

data class LanguageDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("languageName")
    val languageName: String?,
    @SerializedName("languageProficiency")
    val languageProficiency: String?
)