package com.example.beekeepingapi.controller

import com.example.beekeepingapi.domain.dto.request.CreateRequestRequestDto
import com.example.beekeepingapi.domain.dto.response.CreateRequestResponseDto
import com.example.beekeepingapi.domain.dto.response.GetRequestResponseDto
import com.example.beekeepingapi.service.RequestService
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
class RequestController(
    private val requestService: RequestService
) {

    @GetMapping("/admin/request")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getAll(): Flow<GetRequestResponseDto> = requestService.getAll()

    @GetMapping("/request")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getPersonal(principal: Principal): Flow<GetRequestResponseDto> =
        requestService.getPersonal(principal.name)

    @PostMapping("/request")
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(
        @RequestBody createRequestRequestDto: CreateRequestRequestDto,
        principal: Principal
    ): CreateRequestResponseDto =
        requestService.create(createRequestRequestDto, principal.name)

}