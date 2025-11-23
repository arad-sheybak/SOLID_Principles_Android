package com.aradsheybak.feature_srp_user.di

import com.aradsheybak.feature_srp_user.core.domain.repository.UserRepository
import com.aradsheybak.feature_srp_user.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository
}