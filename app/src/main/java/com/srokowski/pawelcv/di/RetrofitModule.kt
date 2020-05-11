package com.srokowski.pawelcv.di

import com.srokowski.pawelcv.retrofit.CvRetrofitClient
import com.srokowski.pawelcv.retrofit.dto.mappers.CvDataDtoValidator
import com.srokowski.pawelcv.retrofit.dto.mappers.CvDataRetrofitMapper
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val retrofitModule = Kodein.Module("RetrofitModule"){
    bind<CvRetrofitClient>() with provider {
        CvRetrofitClient()
    }

    bind<CvDataDtoValidator>() with provider { CvDataDtoValidator() }

    bind<CvDataRetrofitMapper>() with provider {
        CvDataRetrofitMapper(
            validator = instance()
        )
    }
}