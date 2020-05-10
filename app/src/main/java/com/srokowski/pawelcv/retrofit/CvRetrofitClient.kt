package com.srokowski.pawelcv.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CvRetrofitClient {
    private var clientBuilder: OkHttpClient.Builder

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder = OkHttpClient.Builder().addInterceptor(logging)
        clientBuilder.readTimeout(TIMEOUT, TimeUnit.SECONDS)
        clientBuilder.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        clientBuilder.writeTimeout(TIMEOUT, TimeUnit.SECONDS)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.build())
            .build()
    }

    fun getService(): CvService{
        return getRetrofit().create(CvService::class.java)
    }

    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/"
        const val TIMEOUT = 10L
    }
}