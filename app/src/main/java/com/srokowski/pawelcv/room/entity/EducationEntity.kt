package com.srokowski.pawelcv.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EducationEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "faculty")
    val faculty: String,
    @ColumnInfo(name = "university")
    val university: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "startDate")
    val startDate: String,
    @ColumnInfo(name = "endDate")
    val endDate: String?
)