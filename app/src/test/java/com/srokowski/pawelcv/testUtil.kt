package com.srokowski.pawelcv

import com.srokowski.pawelcv.data.entities.*
import com.srokowski.pawelcv.retrofit.dto.*
import com.srokowski.pawelcv.retrofit.dto.skills.ProgrammingSkillDto
import com.srokowski.pawelcv.retrofit.dto.skills.SkillSectionDto
import com.srokowski.pawelcv.retrofit.dto.skills.SkillSectionItemDto
import com.srokowski.pawelcv.retrofit.dto.skills.SkillsDto

val testCvData = CvData(
    1,
    "Pawel",
    "address",
    "emails",
    "phone",
    "occupation",
    Skills(
        listOf(LanguageItem(1,"language","fluent")),
        listOf(ProgrammingSkill(1,"kotlin","advanced")),
        listOf(SkillSection(1,"android", listOf(SkillSectionItem(1,"Junit"))))
    ),
    listOf(Education(1,"computer","agh","master","04.2019",null)),
    listOf(Experience(1,"abb","developer","development","04.2019",null)),
    listOf(ApplicationItem(1,"app","application","author","appurl"))
)

val testDtoData = CvDataDto(
    "address",
    listOf(ApplicationItemDto("application",1,"app","author","appurl")),
    listOf(EducationDto(null,"computer",1,"04.2019","master","agh")),
    "emails",
    listOf(ExperienceDto("abb",null,1,"development", "developer","04.2019")),
    1,
    "Pawel",
    "occupation",
    "phone",
    SkillsDto(
        listOf(LanguageDto(1,"language","fluent")),
        listOf(ProgrammingSkillDto(1,"kotlin","advanced")),
        listOf(SkillSectionDto(1, listOf(SkillSectionItemDto(1,"Junit")),"android"))
    )
)