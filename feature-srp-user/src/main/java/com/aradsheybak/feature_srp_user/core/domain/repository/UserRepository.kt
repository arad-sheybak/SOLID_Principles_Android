package com.aradsheybak.feature_srp_user.core.domain.repository

import com.aradsheybak.feature_srp_user.core.domain.entity.User

interface UserRepository {

    /**
     * Fetches a list of users from the data source.
     */
    suspend fun getUsers(): List<User>

    /**
     * Fetches a single user by their unique ID.
     */
    suspend fun getUserById(id: Int): User?
}