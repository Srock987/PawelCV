package com.srokowski.pawelcv.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "programmingSkills")
data class ProgrammingSkillsEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "skillName")
    val skillName: String,
    @ColumnInfo(name = "skillProficiency")
    val skillProficiency: String
)