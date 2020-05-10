package com.srokowski.pawelcv.data.entities

data class SkillSection(
    val sectionId: Int,
    val sectionName: String,
    val sectionItems: List<SkillSectionItem>
)
