package com.srokowski.pawelcv.di

import com.srokowski.pawelcv.room.CvDatabase
import com.srokowski.pawelcv.room.dao.CvDataDao
import com.srokowski.pawelcv.room.mapper.CvDataRoomFromEntityMapper
import com.srokowski.pawelcv.room.mapper.CvDataRoomToEntityMapper
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val roomModule = Kodein.Module("RoomModule"){
    bind<CvDatabase>() with provider { CvDatabase.getDatabase(instance()) }

    // DAOs
    bind<CvDataDao>() with provider { instance<CvDatabase>().cvDataDao() }

    // Mapper
    bind<CvDataRoomFromEntityMapper>() with provider { CvDataRoomFromEntityMapper() }
    bind<CvDataRoomToEntityMapper>() with provider { CvDataRoomToEntityMapper() }
}