package com.srokowski.pawelcv.di

import com.google.gson.Gson
import com.srokowski.pawelcv.data.dataSources.CvLocalDataSource
import com.srokowski.pawelcv.data.dataSources.CvRemoteDataSource
import com.srokowski.pawelcv.data.repositories.CvDataRepository
import com.srokowski.pawelcv.retrofit.dto.dataSources.CvRetrofitDataSource
import com.srokowski.pawelcv.room.dataSource.CvRoomDataSource
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val dataModule = Kodein.Module("DataModule"){
    bind<Gson>() with provider { Gson() }

    bind<CvRemoteDataSource>() with provider {
        CvRetrofitDataSource(
            mapper = instance(),
            client = instance()
        )
    }

    bind<CvLocalDataSource>() with provider {
        CvRoomDataSource(
            dao = instance(),
            fromMapper = instance(),
            toMapper = instance()
        )
    }

    bind<CvDataRepository>() with provider {
        CvDataRepository(
            local = instance(),
            remote = instance()
        )
    }
}