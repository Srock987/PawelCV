package com.srokowski.pawelcv.data.entities

data class CvData(
    val id: Int,
    val name: String,
    val address: String,
    val email: String,
    val phone: String,
    val occupation: String,
    val skills: Skills,
    val education: List<Education>,
    val experience: List<Experience>,
    val applications: List<ApplicationItem>
)