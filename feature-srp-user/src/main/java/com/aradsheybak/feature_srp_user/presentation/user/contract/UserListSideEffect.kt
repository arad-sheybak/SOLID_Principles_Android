package com.aradsheybak.feature_srp_user.presentation.user.contract

sealed class UserListSideEffect {
    data class ShowToast(val message: String) : UserListSideEffect()
    data class NavigateToUserDetail(val userId: Int) : UserListSideEffect()
}