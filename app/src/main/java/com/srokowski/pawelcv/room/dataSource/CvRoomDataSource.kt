package com.srokowski.pawelcv.room.dataSource

import com.srokowski.pawelcv.data.dataSources.CvLocalDataSource
import com.srokowski.pawelcv.data.entities.CvData
import com.srokowski.pawelcv.room.dao.CvDataDao
import com.srokowski.pawelcv.room.mapper.CvDataRoomFromEntityMapper
import com.srokowski.pawelcv.room.mapper.CvDataRoomToEntityMapper

class CvRoomDataSource(
    private val dao: CvDataDao,
    private val fromMapper: CvDataRoomFromEntityMapper,
    private val toMapper: CvDataRoomToEntityMapper
) : CvLocalDataSource {

    override fun getLocalCvData(id: Int): CvData? {
        val cdData = dao.getCvData(id) ?: return null
        val experience = dao.getExperience().map(fromMapper::mapExperience)
        val education = dao.getEducation().map(fromMapper::mapEducation)
        val applications = dao.getApplications().map(fromMapper::mapApplication)
        val languages = dao.getLanguages().map(fromMapper::mapLanguages)
        val programmingSkill = dao.getProgrammingSkills().map(fromMapper::mapProgrammingSkills)
        val sections = dao.getSections()
            .map { section ->
                fromMapper.mapSection(
                    section,
                    dao.getSectionItem(section.id).map(fromMapper::mapSectionItems)
                )
            }
        val skills = fromMapper.mapSkills(languages, programmingSkill, sections)
        return fromMapper.mapCvData(cdData, education, experience, applications, skills)
    }

    override fun saveCvData(data: CvData) {
        with(data) {
            dao.insertCvData(toMapper.mapCvData(this))
            dao.insertApplication(*applications.map(toMapper::mapApplication).toTypedArray())
            dao.insertEducation(*education.map(toMapper::mapEducation).toTypedArray())
            dao.insertExperience(*experience.map(toMapper::mapExperience).toTypedArray())
            dao.insertLanguages(*skills.languages.map(toMapper::mapLanguages).toTypedArray())
            dao.insertProgrammingSkills(*skills.programmingSkills.map(toMapper::mapProgrammingSkills).toTypedArray())
            dao.insertSection(*skills.skillsSections.map(toMapper::mapSections).toTypedArray())
            skills.skillsSections.forEach { section ->
                dao.insertSectionItems(*section.sectionItems.map {
                    toMapper.mapSectionItem(it, section.sectionId)
                }.toTypedArray())
            }
        }
    }
}