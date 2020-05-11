package com.srokowski.pawelcv.retrofit.dto.mappers

import com.srokowski.pawelcv.retrofit.dto.*
import com.srokowski.pawelcv.retrofit.dto.skills.ProgrammingSkillDto
import com.srokowski.pawelcv.retrofit.dto.skills.SkillSectionDto
import com.srokowski.pawelcv.retrofit.dto.skills.SkillSectionItemDto

class CvDataDtoValidator {
    fun isCvDataValid(dto: CvDataDto): Boolean{
        return try {
            checkNotNull(dto.id)
            checkNotNull(dto.name)
            checkNotNull(dto.address)
            checkNotNull(dto.email)
            checkNotNull(dto.phone)
            checkNotNull(dto.occupation)
            checkNotNull(dto.skills)
            checkNotNull(dto.skills.languages)
            checkNotNull(dto.skills.programmingSkills)
            checkNotNull(dto.skills.sections)
            checkNotNull(dto.experience)
            checkNotNull(dto.applications)
            true
        } catch (exception: IllegalStateException){
            false
        }
    }

    fun isExperienceValid(dto: ExperienceDto): Boolean {
        return try {
            checkNotNull(dto.id)
            checkNotNull(dto.jobTitle)
            checkNotNull(dto.jobDescription)
            checkNotNull(dto.company)
            checkNotNull(dto.startDate)
            true
        } catch (exception: IllegalStateException){
            false
        }
    }

    fun isLanguageValid(dto: LanguageDto): Boolean {
        return try {
            checkNotNull(dto.id)
            checkNotNull(dto.languageName)
            checkNotNull(dto.languageProficiency)
            true
        } catch (exception: IllegalStateException){
            false
        }
    }

    fun isProgrammingSkillValid(dto: ProgrammingSkillDto): Boolean {
        return try {
            checkNotNull(dto.id)
            checkNotNull(dto.skillName)
            checkNotNull(dto.skillProficiency)
            true
        } catch (exception: IllegalStateException){
            false
        }
    }

    fun isSkillSectionValid(skillSectionDto: SkillSectionDto): Boolean {
        return try {
            checkNotNull(skillSectionDto.sectionId)
            checkNotNull(skillSectionDto.sectionName)
            checkNotNull(skillSectionDto.sectionItems)
            true
        } catch (exception: IllegalStateException){
            false
        }
    }

    fun isSkillItemValid(skillSectionItemDto: SkillSectionItemDto): Boolean {
        return try {
            checkNotNull(skillSectionItemDto.id)
            checkNotNull(skillSectionItemDto.item)
            true
        } catch (exception: IllegalStateException){
            false
        }
    }

    fun isEducationValid(educationDto: EducationDto): Boolean {
        return try {
            checkNotNull(educationDto.id)
            checkNotNull(educationDto.faculty)
            checkNotNull(educationDto.university)
            checkNotNull(educationDto.type)
            checkNotNull(educationDto.startDate)
            true
        } catch (exception: IllegalStateException){
            false
        }
    }

    fun isApplicationValid(applicationItemDto: ApplicationItemDto): Boolean {
        return try {
            checkNotNull(applicationItemDto.id)
            checkNotNull(applicationItemDto.name)
            checkNotNull(applicationItemDto.appDescription)
            checkNotNull(applicationItemDto.relation)
            checkNotNull(applicationItemDto.url)
            true
        } catch (exception: java.lang.IllegalStateException){
            false
        }
    }
}