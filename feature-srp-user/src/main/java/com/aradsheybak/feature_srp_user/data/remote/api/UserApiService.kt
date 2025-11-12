package com.aradsheybak.feature_srp_user.data.remote.api

import com.aradsheybak.feature_srp_user.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {
    @GET("users")
    suspend fun getUsers(): List<UserDto>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): UserDto
}