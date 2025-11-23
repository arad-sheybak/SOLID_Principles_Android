package com.aradsheybak.feature_srp_user.di

import com.aradsheybak.feature_srp_user.data.remote.api.UserApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = MoshiProvider().createMoshi()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpProvider().createOkHttpClient()

    @Provides
    @Singleton
    fun provideRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit = RetrofitProvider().createRetrofit(moshi, okHttpClient)

    @Provides
    @Singleton
    fun provideUserApiService(retrofit: Retrofit): UserApiService =
        ApiServiceProvider().createUserApiService(retrofit)
}