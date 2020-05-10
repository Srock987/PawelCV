package com.srokowski.pawelcv.data.dataSources

import com.srokowski.pawelcv.data.entities.CvData

interface CvRemoteDataSource {
    suspend fun fetchCvData(): CvData?
}