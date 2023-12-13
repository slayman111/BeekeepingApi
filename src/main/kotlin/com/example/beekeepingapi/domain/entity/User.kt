package com.example.beekeepingapi.domain.entity

import com.example.beekeepingapi.domain.constant.Role
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.GrantedAuthority

@Table("users")
data class User(
    @Id
    val id: Int? = null,
    val fullName: String,
    val phoneNumber: String,
    val email: String,
    val login: String,
    val password: String,
    val role: Role,
) : GrantedAuthority {

    override fun getAuthority(): String = "ROLE_${role}"

}