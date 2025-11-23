package com.aradsheybak.feature_srp_user.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDto(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "email") val email: String,
    @field:Json(name = "username") val username: String,
    @field:Json(name = "phone") val phone: String,
    @field:Json(name = "website") val website: String,
    @field:Json(name = "address") val address: AddressDto,
    @field:Json(name = "company") val company: CompanyDto
)

@JsonClass(generateAdapter = true)
data class AddressDto(
    @field:Json(name = "street") val street: String,
    @field:Json(name = "suite") val suite: String,
    @field:Json(name = "city") val city: String,
    @field:Json(name = "zipcode") val zipcode: String,
    @field:Json(name = "geo") val geo: GeoDto
)

@JsonClass(generateAdapter = true)
data class GeoDto(
    @field:Json(name = "lat") val lat: String,
    @field:Json(name = "lng") val lng: String
)

@JsonClass(generateAdapter = true)
data class CompanyDto(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "catchPhrase") val catchPhrase: String,
    @field:Json(name = "bs") val bs: String
)