package com.aradsheybak.feature_srp_user.core.domain.entity


data class User(
    val id: Int,
    val name: String,
    val email: String,
    val profileImageUrl: String?,
    val isActive: Boolean)