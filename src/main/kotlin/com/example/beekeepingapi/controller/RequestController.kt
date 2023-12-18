package com.example.beekeepingapi.controller

import com.example.beekeepingapi.domain.dto.request.CreateRequestRequestDto
import com.example.beekeepingapi.domain.dto.response.GetRequestResponseDto
import com.example.beekeepingapi.domain.entity.Request
import com.example.beekeepingapi.service.RequestService
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class RequestController(
    private val requestService: RequestService
) {

    @GetMapping("/admin/request")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getAll(): Flow<GetRequestResponseDto> = requestService.getAll()

    @PostMapping("/request")
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(@RequestBody createRequestRequestDto: CreateRequestRequestDto, principal: Principal): Request =
        requestService.create(createRequestRequestDto, principal.name)

}