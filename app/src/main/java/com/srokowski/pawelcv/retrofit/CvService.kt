package com.srokowski.pawelcv.retrofit

import com.srokowski.pawelcv.retrofit.CvService.Companion.cvPath
import com.srokowski.pawelcv.retrofit.dto.CvDataDto
import retrofit2.http.GET

interface CvService {

    @GET(cvPath)
    suspend fun getCvData(): CvDataDto

    companion object {
        const val cvPath = "Srock987/17eb72c6b8ec2eebef876c95c68bbfc6/raw/f62f18c2706c5234a3c1e19e666a3870935dfc7f/pawelsrokowskicv.json"
    }
}