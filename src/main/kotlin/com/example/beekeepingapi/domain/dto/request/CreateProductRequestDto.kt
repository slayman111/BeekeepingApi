package com.example.beekeepingapi.domain.dto.request

import java.math.BigDecimal

data class CreateProductRequestDto(
    val name: String,
    val price: BigDecimal,
    val productTypeId: Int
)