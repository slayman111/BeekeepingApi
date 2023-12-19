package com.example.beekeepingapi.domain.dto.response

import java.math.BigDecimal

data class GetProductResponseDto(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val productType: String,
    val image: ByteArray? = null,
)
