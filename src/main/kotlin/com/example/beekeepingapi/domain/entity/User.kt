package com.example.beekeepingapi.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User(
    @Id
    val id: Int,
    val fullName: String,
    val phoneNumber: String,
    val email: String,
    val login: String,
    val password: String,
    val roleId: Int,
)