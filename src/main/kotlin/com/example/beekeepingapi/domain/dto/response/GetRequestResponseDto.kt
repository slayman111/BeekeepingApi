package com.example.beekeepingapi.domain.dto.response

data class GetRequestResponseDto(
    val id: Int,
    val user: UserDto,
    val product: GetProductResponseDto,
    val amount: Short,
    val status: String,
    val deliveryDate: Long,
    val createdDate: Long
) {
    data class UserDto(
        val id: Int,
        val fullName: String,
        val email: String,
        val phone: String,
        val role: String
    )
}