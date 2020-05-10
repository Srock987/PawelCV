package com.srokowski.pawelcv.di

import com.srokowski.pawelcv.retrofit.CvRetrofitClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

val retrofitModule = Kodein.Module("RetrofitModule"){
    bind<CvRetrofitClient>() with provider {
        CvRetrofitClient()
    }
}