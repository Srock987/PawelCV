package com.srokowski.pawelcv.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.srokowski.pawelcv.room.entity.*

@Database(
    entities = [
        CvDataEntity::class,
        EducationEntity::class,
        ExperienceEntity::class,
        ApplicationEntity::class,
        LanguageEntity::class,
        ProgrammingSkillsEntity::class,
        SkillSectionEntity::class,
        SkillSectionItemEntity::class
    ],
    version = 1
)
abstract class CvDatabase: RoomDatabase() {


    companion object {
        @Volatile
        private var INSTANCE: CvDatabase? = null

        fun getDatabase(context: Context): CvDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CvDatabase::class.java,
                    "cv_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}