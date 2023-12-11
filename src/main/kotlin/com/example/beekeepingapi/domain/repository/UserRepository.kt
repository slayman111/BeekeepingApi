package com.example.beekeepingapi.domain.repository

import com.example.beekeepingapi.domain.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository : CoroutineCrudRepository<User, Int> {

    suspend fun findByLogin(email: String): User?

}