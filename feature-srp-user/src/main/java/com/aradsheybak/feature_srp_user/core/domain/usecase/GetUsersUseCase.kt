package com.aradsheybak.feature_srp_user.core.domain.usecase
import com.aradsheybak.feature_srp_user.core.domain.entity.User
import com.aradsheybak.feature_srp_user.core.domain.repository.UserRepository
import javax.inject.Inject

/**
 * UseCase responsible for fetching all users.
 *
 * ✅ SRP: Only responsible for retrieving the list of users.
 * ✅ Open for extension, closed for modification.
 */

class GetUsersUseCase @Inject constructor(private val repository: UserRepository){

    suspend operator fun invoke():List<User>{
        return repository.getUsers()
    }
}