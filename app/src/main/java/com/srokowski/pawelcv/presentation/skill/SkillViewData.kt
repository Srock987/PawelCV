package com.srokowski.pawelcv.presentation.skill

sealed class SkillViewData {
    class Header(val header: String): SkillViewData()
    class ProficientSkill(val skillName: String, val proficiency: String): SkillViewData()
    class Skill(val skillName: String): SkillViewData()
}