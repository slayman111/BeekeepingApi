package com.example.beekeepingapi.controller

import com.example.beekeepingapi.domain.dto.request.CreateRequestRequestDto
import com.example.beekeepingapi.domain.entity.Request
import com.example.beekeepingapi.service.RequestService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class RequestController(
    private val requestService: RequestService
) {

    @PostMapping("/request")
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(@RequestBody createRequestRequestDto: CreateRequestRequestDto, principal: Principal): Request =
        requestService.create(createRequestRequestDto, principal.name)

}