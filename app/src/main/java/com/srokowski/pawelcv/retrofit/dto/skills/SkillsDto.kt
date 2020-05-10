package com.srokowski.pawelcv.retrofit.dto.skills


import com.google.gson.annotations.SerializedName
import com.srokowski.pawelcv.retrofit.dto.LanguageDto

data class SkillsDto(
    @SerializedName("languages")
    val languages: List<LanguageDto>?,
    @SerializedName("programmingSkills")
    val programmingSkills: List<ProgrammingSkillDto>?,
    @SerializedName("sections")
    val sections: List<SkillSectionDto>?
)