package com.aradsheybak.feature_srp_user.data.mapper

import com.aradsheybak.feature_srp_user.core.domain.entity.User
import com.aradsheybak.feature_srp_user.data.remote.dto.UserDto

fun UserDto.toDomain(): User {
    return User(
        id = id,
        name = name,
        email = email,
        profileImageUrl = "https://i.pravatar.cc/150?u=$email",
        isActive = true
    )
}