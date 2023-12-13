package com.example.beekeepingapi.service

import com.example.beekeepingapi.domain.dto.request.CreateRequestRequestDto
import com.example.beekeepingapi.domain.entity.Request
import com.example.beekeepingapi.domain.repository.RequestRepository
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Service
class RequestService(
    private val requestRepository: RequestRepository,
    private val userService: UserService
) {

    suspend fun create(createRequestRequestDto: CreateRequestRequestDto, name: String) =
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
