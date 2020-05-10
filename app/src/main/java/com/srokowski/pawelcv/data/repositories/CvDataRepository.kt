package com.srokowski.pawelcv.data.repositories

import com.srokowski.pawelcv.data.dataSources.CvLocalDataSource
import com.srokowski.pawelcv.data.dataSources.CvRemoteDataSource
import com.srokowski.pawelcv.data.entities.CvData
import kotlinx.coroutines.flow.Flow

class CvDataRepository(
    private val local: CvLocalDataSource,
    private val remote: CvRemoteDataSource
): BaseRepository() {
    suspend fun getCvData(): Flow<Result<CvData>>{
        return getBoundResource(
            getLocal = { local.getLocalCvData() },
            getRemote = { remote.fetchCvData() },
            casheRemoteData = { local.saveCvData(it) },
            isValidData = { data -> data != null }
        )
    }
}