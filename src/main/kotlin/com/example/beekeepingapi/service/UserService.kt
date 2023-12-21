package com.example.beekeepingapi.service

import com.example.beekeepingapi.domain.entity.User
import com.example.beekeepingapi.domain.repository.UserRepository
import com.example.beekeepingapi.exception.HttpExceptionFactory.unauthorized
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    suspend fun findByLogin(login: String): User? =
        userRepository.findByLogin(login) ?: throw unauthorized()

    suspend fun findAll(): Flow<User> =
        userRepository.findAll()

    suspend fun deleteById(id: Int): Unit =
        userRepository.deleteById(id)

}