package com.example.beekeepingapi.controller

import com.example.beekeepingapi.domain.constant.Role
import com.example.beekeepingapi.domain.dto.request.LoginRequestDto
import com.example.beekeepingapi.domain.entity.User
import com.example.beekeepingapi.domain.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder,
) {

    @PostMapping("/register")
    suspend fun register(@RequestBody loginRequestDto: LoginRequestDto) =
        userRepository.save(
            User(
                id = null,
                fullName = "a",
                phoneNumber = "asds",
                email = "sadsa",
                login = loginRequestDto.login,
                password = passwordEncoder.encode(loginRequestDto.password),
                role = Role.USER
            )
        )

}