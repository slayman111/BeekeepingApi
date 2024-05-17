package com.example.beekeepingapi.domain.dto.response

data class CreateRequestResponseDto(
    val id: Int,
    val userId: Int,
    val productId: Int,
    val amount: Short,
    val statusId: Int,
    val deliveryDate: Long,
    val createdDate: Long
)
