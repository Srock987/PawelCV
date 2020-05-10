package com.srokowski.pawelcv.data.repositories

import com.srokowski.pawelcv.data.dataSources.CvLocalDataSource
import com.srokowski.pawelcv.data.dataSources.CvRemoteDataSource
import com.srokowski.pawelcv.data.dataSources.SharedPreferencesIdStorage
import com.srokowski.pawelcv.data.entities.CvData
import kotlinx.coroutines.flow.Flow

class CvDataRepository(
    private val local: CvLocalDataSource,
    private val remote: CvRemoteDataSource,
    private val idStorage: SharedPreferencesIdStorage
): BaseRepository() {
    suspend fun getCvData(): Flow<Result<CvData>>{
        return getBoundResource(
            getLocal = { local.getLocalCvData(idStorage.getStoredCvId()) },
            getRemote = { remote.fetchCvData() },
            casheRemoteData = {
                local.saveCvData(it)
                idStorage.storeCvId(it.id)
            },
            isValidData = { data -> data != null }
        )
    }
}