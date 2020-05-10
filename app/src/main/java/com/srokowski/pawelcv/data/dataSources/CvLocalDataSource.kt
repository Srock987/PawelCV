package com.srokowski.pawelcv.data.dataSources

import com.srokowski.pawelcv.data.entities.CvData

interface CvLocalDataSource {
    fun getLocalCvData(id: Int): CvData?
    fun saveCvData(data: CvData)
}