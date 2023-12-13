package com.example.beekeepingapi.domain.dto.request

data class RegisterRequestDto(
    val fullName: String,
    val phoneNumber: String,
    val email: String,
    val login: String,
    val password: String,
)
