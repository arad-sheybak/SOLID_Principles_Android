package com.aradsheybak.feature_srp_user.presentation.user.contract

import com.aradsheybak.feature_srp_user.core.domain.entity.User

sealed class UserListIntent {
    object LoadUsers : UserListIntent()
    object Retry : UserListIntent()
    data class UserClicked(val user: User) : UserListIntent()
}