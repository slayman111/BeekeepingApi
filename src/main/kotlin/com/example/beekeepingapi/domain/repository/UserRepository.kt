package com.example.beekeepingapi.domain.repository

import com.example.beekeepingapi.domain.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import reactor.core.publisher.Mono

interface UserRepository : CoroutineCrudRepository<User, Int> {

    suspend fun findByLogin(email: String): User?

}