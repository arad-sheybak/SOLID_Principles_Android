package com.aradsheybak.feature_srp_user.core.domain.repository

import com.aradsheybak.feature_srp_user.core.domain.entity.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUserById(id: Int): User?
}