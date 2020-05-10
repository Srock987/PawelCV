package com.srokowski.pawelcv.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "language")
data class LanguageEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "languageName")
    val languageName: String,
    @ColumnInfo(name = "languageProficiency")
    val languageProficiency: String
)