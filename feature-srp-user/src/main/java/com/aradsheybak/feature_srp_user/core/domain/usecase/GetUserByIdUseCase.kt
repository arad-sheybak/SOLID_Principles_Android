package com.aradsheybak.feature_srp_user.core.domain.usecase

import com.aradsheybak.feature_srp_user.core.domain.entity.User
import com.aradsheybak.feature_srp_user.core.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(private val repository: UserRepository){
    suspend operator fun invoke(id: Int): User?{
        return repository.getUserById(id)
    }
}