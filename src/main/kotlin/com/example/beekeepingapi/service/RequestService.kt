package com.example.beekeepingapi.service

import com.example.beekeepingapi.domain.dto.request.CreateRequestRequestDto
import com.example.beekeepingapi.domain.dto.response.GetProductResponseDto
import com.example.beekeepingapi.domain.dto.response.GetRequestResponseDto
import com.example.beekeepingapi.domain.entity.Request
import com.example.beekeepingapi.domain.repository.RequestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Service
class RequestService(
    private val requestRepository: RequestRepository,
    private val userService: UserService
) {

    suspend fun getAll(): Flow<GetRequestResponseDto> =
        requestRepository.findAllProjected()
            .map {
                GetRequestResponseDto(
                    id = it.productId,
                    user = GetRequestResponseDto.UserDto(
                        id = it.userId,
                        email = it.userEmail,
                        phone = it.userPhoneNumber,
                        fullName = it.userFullName,
                        role = it.userRole
                    ),
                    product = GetProductResponseDto(
                        id = it.productId,
                        name = it.productName,
                        price = it.productPrice,
                        productType = it.productType,
                        image = it.productImage
                    ),
                    amount = it.requestAmount,
                    status = it.requestStatus,
                    deliveryDate = it.requestDeliveryDate,
                    createdDate = it.requestCreatedDate
                )
            }

    suspend fun create(createRequestRequestDto: CreateRequestRequestDto, name: String): Request =
        requestRepository.save(
            Request(
                userId = userService.findByLogin(name)?.id!!,
                productId = createRequestRequestDto.productId,
                amount = createRequestRequestDto.amount,
                statusId = 1,
                deliveryDate = LocalDateTime.ofInstant(
                    Instant.ofEpochMilli(createRequestRequestDto.deliveryDate),
                    TimeZone.getDefault().toZoneId()
                )
            )
        )

}
