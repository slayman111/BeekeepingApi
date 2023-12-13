package com.example.beekeepingapi.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("statuses")
data class Status(
    @Id
    val id: Int? = null,
    val name: String,
)