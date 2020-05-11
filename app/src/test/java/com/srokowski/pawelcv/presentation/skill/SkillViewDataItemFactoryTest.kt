package com.srokowski.pawelcv.presentation.skill

import com.srokowski.pawelcv.testCvData
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeIn
import org.amshove.kluent.shouldEqual
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class SkillViewDataItemFactoryTest {

    lateinit var subject: SkillViewDataItemFactory

    @Before
    fun setUp() {
        subject = SkillViewDataItemFactory()
    }

    @Test
    fun `Given valid list, When create called, Then appropriate list returned`(){
        val data = testCvData.skills
        val result = subject.create(data)
        result.isNotEmpty() shouldBe true
        result.mapNotNull { it as? SkillViewData.Header }.size shouldEqual 3
        result.mapNotNull { it as? SkillViewData.Skill }.size shouldEqual 1
        result.mapNotNull { it as? SkillViewData.ProficientSkill }.size shouldEqual 2
    }

    @Test
    fun `Given list without sections, When create called, Then appropriate list returned`(){
        val data = testCvData.skills.copy(skillsSections = emptyList())
        val result = subject.create(data)
        result.isNotEmpty() shouldBe true
        result.mapNotNull { it as? SkillViewData.Header }.size shouldEqual 2
        result.mapNotNull { it as? SkillViewData.Skill }.size shouldEqual 0
        result.mapNotNull { it as? SkillViewData.ProficientSkill }.size shouldEqual 2
    }
}