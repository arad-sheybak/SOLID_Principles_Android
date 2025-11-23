package com.aradsheybak.feature_srp_user.di

import com.aradsheybak.feature_srp_user.data.remote.api.UserApiService
import retrofit2.Retrofit

class ApiServiceProvider {
    fun createUserApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }
}