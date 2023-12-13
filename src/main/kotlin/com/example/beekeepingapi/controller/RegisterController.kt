package com.example.beekeepingapi.controller

import com.example.beekeepingapi.domain.dto.request.RegisterRequestDto
import com.example.beekeepingapi.service.RegisterService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterController(
    private val registerService: RegisterService
) {

    @PostMapping("/register")
    suspend fun register(@RequestBody registerRequestDto: RegisterRequestDto) =
        registerService.register(registerRequestDto)

}