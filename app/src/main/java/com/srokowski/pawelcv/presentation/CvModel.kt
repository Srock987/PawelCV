package com.srokowski.pawelcv.presentation

import com.srokowski.pawelcv.data.entities.CvData
import com.srokowski.pawelcv.data.repositories.CvDataRepository
import kotlinx.coroutines.flow.Flow

class CvModel(
    private val repository: CvDataRepository
) : CvModelContract.Model {
    override suspend fun getCvData(): Flow<Result<CvData>> {
        return repository.getCvData()
    }
}