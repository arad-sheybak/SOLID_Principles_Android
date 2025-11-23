package com.aradsheybak.feature_srp_user.di

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitProvider {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    fun createRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient,
        baseUrl: String = BASE_URL
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}