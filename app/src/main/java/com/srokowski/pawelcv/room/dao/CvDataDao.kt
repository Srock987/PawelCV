package com.srokowski.pawelcv.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.srokowski.pawelcv.room.entity.*

@Dao
interface CvDataDao {
    @Query("SELECT * FROM cvData WHERE id=:id")
    fun getCvData(id: Int): CvDataEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCvData(cvData: CvDataEntity)

    @Query("SELECT * FROM experience")
    fun getExperience(): List<ExperienceEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExperience(vararg experienceEntity: ExperienceEntity)

    @Query("SELECT * FROM education")
    fun getEducation(): List<EducationEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEducation(vararg educationEntity: EducationEntity)

    @Query("SELECT * FROM application")
    fun getApplications(): List<ApplicationEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertApplication(vararg applicationEntity: ApplicationEntity)

    @Query("SELECT * FROM skillSection")
    fun getSections(): List<SkillSectionEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSection(vararg sectionEntity: SkillSectionEntity)

    @Query("SELECT * FROM skillSectionItem")
    fun getSectionItem(): List<SkillSectionItemEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSectionItems(vararg sectionItemEntity: SkillSectionItemEntity)
}