package com.srokowski.pawelcv.retrofit.dto.dataSources

import com.srokowski.pawelcv.data.dataSources.CvRemoteDataSource
import com.srokowski.pawelcv.data.entities.CvData
import com.srokowski.pawelcv.retrofit.CvRetrofitClient
import com.srokowski.pawelcv.retrofit.dto.mappers.CvDataRetrofitMapper

class CvRetrofitDataSource(
    private val mapper: CvDataRetrofitMapper,
    client: CvRetrofitClient
): CvRemoteDataSource {

    private val service = client.getService()

    override suspend fun fetchCvData(): CvData? {
        return mapper.mapToData(service.getCvData())
    }
}