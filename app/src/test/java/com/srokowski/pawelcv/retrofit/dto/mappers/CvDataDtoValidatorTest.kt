package com.srokowski.pawelcv.retrofit.dto.mappers

import com.srokowski.pawelcv.testDtoData
import org.amshove.kluent.shouldBe
import org.junit.Before

import org.junit.Test

class CvDataDtoValidatorTest {

    lateinit var subject: CvDataDtoValidator

    @Before
    fun setUp() {
        subject = CvDataDtoValidator()
    }

    @Test
    fun `Given valid data, When is isCvDataValid, Then true returned`(){
        val data = testDtoData
        val result = subject.isCvDataValid(data)
        result shouldBe true
    }

    @Test
    fun `Given invalid data, When is isCvDataValid, Then false returned`(){
        val data = testDtoData.copy(name = null)
        val result = subject.isCvDataValid(data)
        result shouldBe false
    }

    @Test
    fun `Given valid application data, When isApplicationValid called, Then true returned`(){
        val appData = testDtoData.applications
        val result = subject.isApplicationValid(appData!!.first())
        result shouldBe true
    }

    @Test
    fun `Given invalid application data, When isApplicationValid called, Then false returned`(){
        val appData = testDtoData.applications!!.first().copy(appDescription = null)
        val result = subject.isApplicationValid(appData)
        result shouldBe false
    }

    @Test
    fun `Given valid education data, When isEducationValid called, Then true returned`(){
        val appData = testDtoData.education!!.first()
        val result = subject.isEducationValid(appData)
        result shouldBe true
    }

    @Test
    fun `Given invalid education data, When isEducationValid called, Then false returned`(){
        val appData = testDtoData.education!!.first().copy(faculty = null)
        val result = subject.isEducationValid(appData)
        result shouldBe false
    }

    @Test
    fun `Given valid experience data, When isExperienceValid called, Then true returned`(){
        val appData = testDtoData.experience!!.first()
        val result = subject.isExperienceValid(appData)
        result shouldBe true
    }

    @Test
    fun `Given invalid experience data, When isExperienceValid called, Then false returned`(){
        val appData = testDtoData.experience!!.first().copy(company = null)
        val result = subject.isExperienceValid(appData)
        result shouldBe false
    }

    @Test
    fun `Given valid languages data, When isLanguageValid called, Then true returned`(){
        val appData = testDtoData.skills!!.languages!!.first()
        val result = subject.isLanguageValid(appData)
        result shouldBe true
    }

    @Test
    fun `Given invalid languages data, When isExperienceValid called, Then false returned`(){
        val appData = testDtoData.skills!!.languages!!.first().copy(id = null)
        val result = subject.isLanguageValid(appData)
        result shouldBe false
    }

    @Test
    fun `Given valid programmingSkills data, When isProgrammingSkillValid called, Then true returned`(){
        val appData = testDtoData.skills!!.programmingSkills!!.first()
        val result = subject.isProgrammingSkillValid(appData)
        result shouldBe true
    }

    @Test
    fun `Given invalid programmingSkills data, When isProgrammingSkillValid called, Then false returned`(){
        val appData = testDtoData.skills!!.programmingSkills!!.first().copy(id = null)
        val result = subject.isProgrammingSkillValid(appData)
        result shouldBe false
    }

    @Test
    fun `Given valid section data, When isSkillSectionValid called, Then true returned`(){
        val appData = testDtoData.skills!!.sections!!.first()
        val result = subject.isSkillSectionValid(appData)
        result shouldBe true
    }

    @Test
    fun `Given invalid section data, When isSkillSectionValid called, Then false returned`(){
        val appData = testDtoData.skills!!.sections!!.first().copy(sectionId = null)
        val result = subject.isSkillSectionValid(appData)
        result shouldBe false
    }

    @Test
    fun `Given valid section data, When isSkillItemValid called, Then true returned`(){
        val appData = testDtoData.skills!!.sections!!.first().sectionItems!!.first()
        val result = subject.isSkillItemValid(appData)
        result shouldBe true
    }

    @Test
    fun `Given invalid section data, When isSkillItemValid called, Then false returned`(){
        val appData = testDtoData.skills!!.sections!!.first().sectionItems!!.first().copy(id = null)
        val result = subject.isSkillItemValid(appData)
        result shouldBe false
    }
}