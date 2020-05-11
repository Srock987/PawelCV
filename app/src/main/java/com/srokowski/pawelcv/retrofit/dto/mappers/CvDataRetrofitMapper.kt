package com.srokowski.pawelcv.retrofit.dto.mappers

import com.srokowski.pawelcv.data.entities.*
import com.srokowski.pawelcv.retrofit.dto.*
import com.srokowski.pawelcv.retrofit.dto.skills.ProgrammingSkillDto
import com.srokowski.pawelcv.retrofit.dto.skills.SkillSectionDto
import com.srokowski.pawelcv.retrofit.dto.skills.SkillSectionItemDto
import com.srokowski.pawelcv.retrofit.dto.skills.SkillsDto

class CvDataRetrofitMapper(
    private val validator: CvDataDtoValidator
) {
    fun mapToData(dto: CvDataDto) = with(dto) {
        if (validator.isCvDataValid(this)) {
            CvData(
                id!!,
                name!!,
                address!!,
                email!!,
                phone!!,
                occupation!!,
                mapSkills(skills!!),
                education!!.mapNotNull(::mapEducation),
                experience!!.mapNotNull(::mapExperience),
                applications!!.mapNotNull(::mapApplication)
                )
        } else null
    }

    private fun mapSkills(skillsDto: SkillsDto): Skills {
        return Skills(
            skillsDto.languages!!.mapNotNull(::mapLanguages),
            skillsDto.programmingSkills!!.mapNotNull(::mapProgrammingSkills),
            skillsDto.sections!!.mapNotNull(::mapSkillSections)
        )
    }

    private fun mapLanguages(dto: LanguageDto) = with(dto) {
        if (validator.isLanguageValid(this)) {
            LanguageItem(
                id!!,
                languageName!!,
                languageProficiency!!
            )
        } else null
    }

    private fun mapProgrammingSkills(dto: ProgrammingSkillDto) = with(dto){
        if (validator.isProgrammingSkillValid(this)){
            ProgrammingSkill(
                id!!,
                skillName!!,
                skillProficiency!!
            )
        } else null
    }

    private fun mapSkillSections(sectionDto: SkillSectionDto) = with(sectionDto){
        if (validator.isSkillSectionValid(this)){
            SkillSection(
                sectionId!!,
                sectionName!!,
                sectionItems!!.mapNotNull(::mapSkillSectionItem)
            )
        } else null
    }

    private fun mapSkillSectionItem(skillItemDto: SkillSectionItemDto) = with(skillItemDto){
        if (validator.isSkillItemValid(this)){
            SkillSectionItem(
                id!!,
                item!!
            )
        } else null
    }

    private fun mapEducation(educationDto: EducationDto) = with(educationDto){
        if (validator.isEducationValid(this)){
            Education(
                id!!,
                faculty!!,
                university!!,
                type!!,
                startDate!!,
                endDate
            )
        } else null
    }

    private fun mapExperience(experienceDto: ExperienceDto) = with(experienceDto) {
        if (validator.isExperienceValid(this)) {
            Experience(
                id!!,
                company!!,
                jobTitle!!,
                jobDescription!!,
                startDate!!,
                endDate
            )
        } else null
    }

    private fun mapApplication(applicationDto: ApplicationItemDto) = with(applicationDto) {
        if (validator.isApplicationValid(this)){
            ApplicationItem(
                id!!,
                name!!,
                appDescription!!,
                relation!!,
                url!!
            )
        } else null
    }
}