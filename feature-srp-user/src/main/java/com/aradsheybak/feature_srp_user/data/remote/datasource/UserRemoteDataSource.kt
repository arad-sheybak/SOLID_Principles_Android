package com.aradsheybak.feature_srp_user.data.remote.datasource

import com.aradsheybak.feature_srp_user.data.remote.api.UserApiService
import com.aradsheybak.feature_srp_user.data.remote.dto.UserDto

class UserRemoteDataSource(private val apiService: UserApiService) {
    suspend fun getUsers(): List<UserDto> = apiService.getUsers()

    suspend fun getUserById(id: Int): UserDto? = apiService.getUserById(id)

}