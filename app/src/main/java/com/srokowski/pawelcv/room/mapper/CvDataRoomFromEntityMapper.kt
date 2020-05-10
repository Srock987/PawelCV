package com.srokowski.pawelcv.room.mapper

import com.srokowski.pawelcv.data.entities.*
import com.srokowski.pawelcv.room.entity.*

class CvDataRoomFromEntityMapper {

    fun mapCvData(
        cvDataEntity: CvDataEntity,
        education: List<Education>,
        experience: List<Experience>,
        applications: List<ApplicationItem>,
        skills: Skills
        ) = with(cvDataEntity) {
        CvData(
            id,
            name,
            address,
            email,
            phone,
            occupation,
            skills,
            education,
            experience,
            applications
        )
    }

    fun mapEducation(educationEntity: EducationEntity) = with(educationEntity) {
        Education(
            id,
            faculty,
            university,
            type,
            startDate,
            endDate
        )
    }

    fun mapExperience(experienceEntity: ExperienceEntity) = with(experienceEntity) {
        Experience(
            id,
            company,
            jobTitle,
            jobDescription,
            startDate,
            endDate
        )
    }

    fun mapApplication(applicationEntity: ApplicationEntity) = with(applicationEntity) {
        ApplicationItem(
            id,
            name,
            appDescription,
            relation,
            url
        )
    }

    fun mapLanguages(languageEntity: LanguageEntity) = with(languageEntity) {
        LanguageItem(
            id,
            languageName,
            languageProficiency
        )
    }

    fun mapProgrammingSkills(programmingSkillsEntity: ProgrammingSkillsEntity) =
        with(programmingSkillsEntity) {
            ProgrammingSkill(
                id,
                skillName,
                skillProficiency
            )
        }

    fun mapSectionItems(sectionItemEntity: SkillSectionItemEntity) = with(sectionItemEntity) {
        SkillSectionItem(
            itemId,
            skillName
        )
    }

    fun mapSection(sectionEntity: SkillSectionEntity, items: List<SkillSectionItem>) =
        with(sectionEntity) {
            SkillSection(
                id,
                sectionName,
                items
            )
        }

    fun mapSkills(
        languages: List<LanguageItem>,
        programmingSkill: List<ProgrammingSkill>,
        sections: List<SkillSection>
    ): Skills {
        return Skills(languages, programmingSkill, sections)
    }
}