package com.aradsheybak.feature_srp_user.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDto(@Json(name = "id") val id:Int,
    @Json(name = "full_name") val fullName: String,
    @Json(name = "email")val email: String,
    @Json(name = "profile")val profile: String?,
    @Json(name = "active")val isActive: Boolean)
