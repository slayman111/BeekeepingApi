package com.example.beekeepingapi.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal

@Table("products")
data class Product(
    @Id
    val id: Int? = null,
    val name: String,
    val price: BigDecimal,
    val productTypeId: BigDecimal,
    val image: List<Byte>? = emptyList(),
)