package com.srokowski.pawelcv.presentation

import androidx.lifecycle.LiveData
import com.srokowski.pawelcv.data.entities.CvData
import kotlinx.coroutines.flow.Flow

interface CvModelContract {
    interface ViewModel{}
    interface Model{
        suspend fun getCvData(): Flow<Result<CvData>>
    }
}