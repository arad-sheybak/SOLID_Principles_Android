package com.aradsheybak.feature_srp_user.data.repository

import com.aradsheybak.feature_srp_user.core.domain.entity.User
import com.aradsheybak.feature_srp_user.core.domain.repository.UserRepository
import com.aradsheybak.feature_srp_user.data.mapper.toDomain
import com.aradsheybak.feature_srp_user.data.remote.datasource.UserRemoteDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return userRemoteDataSource.getUsers().map { it.toDomain() }
    }

    override suspend fun getUserById(id: Int): User? {
        return userRemoteDataSource.getUserById(id)?.toDomain()
    }
}
