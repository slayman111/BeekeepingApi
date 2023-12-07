package com.example.beekeepingapi.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("roles")
data class Role(
    @Id
    val id: Int,
    val name: String,
)