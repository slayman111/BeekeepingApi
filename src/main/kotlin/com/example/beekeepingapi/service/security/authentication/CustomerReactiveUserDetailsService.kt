package com.example.beekeepingapi.service.security.authentication

import com.example.beekeepingapi.domain.repository.UserRepository
import kotlinx.coroutines.reactor.mono
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CustomerReactiveUserDetailsService(private val userRepository: UserRepository) : ReactiveUserDetailsService {

    override fun findByUsername(username: String?): Mono<UserDetails> = mono {
        val user = userRepository.findByLogin(username!!) ?: throw BadCredentialsException("Invalid Credentials")
        return@mono User(user.login, user.password, listOf(user))
    }
}