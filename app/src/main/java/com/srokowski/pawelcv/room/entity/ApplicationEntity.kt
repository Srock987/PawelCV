package com.srokowski.pawelcv.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "application")
data class ApplicationEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "appDescription")
    val appDescription: String,
    @ColumnInfo(name = "relation")
    val relation: String,
    @ColumnInfo(name = "url")
    val url: String
)