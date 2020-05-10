package com.srokowski.pawelcv.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "skillSectionItem", primaryKeys = ["itemId", "sectionId"])
data class SkillSectionItemEntity(
    @ColumnInfo(name = "itemId")
    val itemId: Int,
    @ColumnInfo(name = "sectionId")
    val sectionId: Int,
    @ColumnInfo(name = "skillName")
    val skillName: String
)