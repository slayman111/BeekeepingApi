package com.example.beekeepingapi.domain.projection

import java.math.BigDecimal

data class ProductProjection(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val productType: String,
    val image: ByteArray? = null,
)