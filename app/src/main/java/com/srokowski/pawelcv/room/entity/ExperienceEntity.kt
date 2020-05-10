package com.srokowski.pawelcv.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "experience")
data class ExperienceEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "company")
    val company: String,
    @ColumnInfo(name = "jobTitle")
    val jobTitle: String,
    @ColumnInfo(name = "jobDescription")
    val jobDescription: String,
    @ColumnInfo(name = "startDate")
    val startDate: String,
    @ColumnInfo(name = "endDate")
    val endDate: String
)