package com.srokowski.pawelcv.room.mapper

import com.srokowski.pawelcv.data.entities.*
import com.srokowski.pawelcv.room.entity.*

class CvDataRoomToEntityMapper {
    fun mapCvData(cvData: CvData) = with(cvData) {
        CvDataEntity(
            id,
            name,
            address,
            email,
            phone,
            occupation
        )
    }

    fun mapExperience(experience: Experience) = with(experience) {
        ExperienceEntity(
            id,
            company,
            jobTitle,
            jobDescription,
            startDate,
            endDate
        )
    }

    fun mapEducation(education: Education) = with(education) {
        EducationEntity(
            id,
            faculty,
            university,
            type,
            startDate,
            endDate
        )
    }

    fun mapApplication(applicationItem: ApplicationItem) = with(applicationItem) {
        ApplicationEntity(
            id,
            name,
            appDescription,
            relation,
            url
        )
    }

    fun mapLanguages(languageItem: LanguageItem) = with(languageItem){
        LanguageEntity(
            id,
            languageName,
            languageProficiency
        )
    }

    fun mapProgrammingSkills(programmingSkill: ProgrammingSkill) = with(programmingSkill){
        ProgrammingSkillsEntity(
            id,
            skillName,
            skillProficiency
        )
    }

    fun mapSections(section: SkillSection) = with(section) {
        SkillSectionEntity(
            sectionId,
            sectionName
        )
    }

    fun mapSectionItem(sectionItem: SkillSectionItem, sectionId: Int) = with(sectionItem) {
        SkillSectionItemEntity(
            id,
            sectionId,
            skillName
        )
    }
}