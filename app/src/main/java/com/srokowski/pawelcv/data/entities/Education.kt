package com.srokowski.pawelcv.data.entities

data class Education(
    val id: Int,
    val faculty: String,
    val university: String,
    val type: String,
    val startDate: String,
    val endDate: String?
)
