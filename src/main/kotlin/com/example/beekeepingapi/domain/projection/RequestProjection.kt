package com.example.beekeepingapi.domain.projection

import java.math.BigDecimal

data class RequestProjection(
    val requestId: Int,
    val userId: Int,
    val userFullName: String,
    val userEmail: String,
    val userPhoneNumber: String,
    val userRole: String,
    val requestStatus: String,
    val productId: Int,
    val productName: String,
    val productPrice: BigDecimal,
    val productType: String,
    val productImage: ByteArray?,
    val requestAmount: Short,
    val requestDeliveryDate: Long,
    val requestCreatedDate: Long,
)
