package com.aradsheybak.feature_srp_user.presentation.user.contract

import com.aradsheybak.feature_srp_user.core.domain.entity.User

data class UserListState(
    val users: List<User> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)