package com.example.beekeepingapi.domain.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("requests")
data class Request(
    @Id
    val id: Int,
    val userId: Int,
    val productId: Int,
    val amount: Short,
    val statusId: Int,
    val deliveryDate: LocalDateTime,
    @CreatedDate
    val createdDate: LocalDateTime,
)