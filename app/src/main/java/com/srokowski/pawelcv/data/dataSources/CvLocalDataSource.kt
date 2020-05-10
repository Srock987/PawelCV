package com.srokowski.pawelcv.data.dataSources

import com.srokowski.pawelcv.data.entities.CvData

interface CvLocalDataSource {
    fun getLocalCvData(): CvData?
    fun saveCvData(data: CvData)
}