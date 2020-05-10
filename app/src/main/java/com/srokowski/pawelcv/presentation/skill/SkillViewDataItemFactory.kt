package com.srokowski.pawelcv.presentation.skill

import com.srokowski.pawelcv.data.entities.LanguageItem
import com.srokowski.pawelcv.data.entities.ProgrammingSkill
import com.srokowski.pawelcv.data.entities.SkillSection
import com.srokowski.pawelcv.data.entities.Skills

class SkillViewDataItemFactory {

    fun create(skills: Skills) = with(skills){
        val result = mutableListOf<SkillViewData>()
        result.addAll(createLanguageItems(languages))
        result.addAll(createProgrammingSkillsItems(programmingSkills))
        result.addAll(createSkillSectionsItems(skillsSections))
        result.toList()
    }

    private fun createLanguageItems(languages: List<LanguageItem>): List<SkillViewData>{
        val result = mutableListOf<SkillViewData>()
         if (languages.isNotEmpty()) {
            result.add(SkillViewData.Header(LANGUAGE_HEADER))
            result.addAll(languages.map { SkillViewData.ProficientSkill(it.languageName, it.languageProficiency) })
        }
        return result
    }

    private fun createProgrammingSkillsItems(programmingSkills: List<ProgrammingSkill>): List<SkillViewData>{
        val result = mutableListOf<SkillViewData>()
        if (programmingSkills.isNotEmpty()) {
            result.add(SkillViewData.Header(PROGRAMMING_HEADER))
            result.addAll(programmingSkills.map { SkillViewData.ProficientSkill(it.skillName, it.skillProficiency) })
        }
        return result
    }

    private fun createSkillSectionsItems(skillSections: List<SkillSection>): List<SkillViewData>{
        return skillSections.map {
            val skills = mutableListOf<SkillViewData>(SkillViewData.Header(it.sectionName))
            skills.addAll(it.sectionItems.map { SkillViewData.Skill(it.skillName) })
            return@map skills
        }.flatten()
    }

    companion object {
        const val LANGUAGE_HEADER = "Languages"
        const val PROGRAMMING_HEADER = "Programming Skills"
    }
}