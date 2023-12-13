package com.example.beekeepingapi.service

import com.example.beekeepingapi.domain.constant.Role
import com.example.beekeepingapi.domain.dto.request.RegisterRequestDto
import com.example.beekeepingapi.domain.entity.User
import com.example.beekeepingapi.domain.repository.UserRepository
import com.example.beekeepingapi.exception.HttpExceptionFactory
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class RegisterService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    suspend fun register(registerRequestDto: RegisterRequestDto): User {
        if (userRepository.findByLogin(registerRequestDto.login) != null) {
            throw HttpExceptionFactory.loginAlreadyExists()
        }

        return userRepository.save(
            User(
                id = null,
                fullName = registerRequestDto.fullName,
                phoneNumber = registerRequestDto.phoneNumber,
                email = registerRequestDto.email,
                login = registerRequestDto.login,
                password = passwordEncoder.encode(registerRequestDto.password),
                role = Role.USER
            )
        )
    }


}