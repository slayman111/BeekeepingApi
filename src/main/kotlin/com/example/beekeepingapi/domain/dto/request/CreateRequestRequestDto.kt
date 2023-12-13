package com.example.beekeepingapi.domain.dto.request

data class CreateRequestRequestDto(
    val productId: Int,
    val amount: Short,
    val deliveryDate: Long,
)
