package com.srokowski.pawelcv.data.entities

data class Experience(
    val id: Int,
    val company: String,
    val jobTitle: String,
    val jobDescription: String,
    val startDate: String,
    val endDate: String?
)