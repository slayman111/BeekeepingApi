package com.example.beekeepingapi.service.security.authentication

import com.example.beekeepingapi.exception.HttpExceptionFactory.unauthorized
import kotlinx.coroutines.reactor.mono
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.WebFilterExchange
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class JWTServerAuthenticationSuccessHandler(private val jwtService: JWTService) : ServerAuthenticationSuccessHandler {

    companion object {
        private const val FOUR_HOURS = 1000 * 60 * 60 * 4
        private const val EIGHT_HOURS = 1000 * 60 * 60 * 8
    }

    override fun onAuthenticationSuccess(
        webFilterExchange: WebFilterExchange?,
        authentication: Authentication?
    ): Mono<Void> = mono {
        val principal = authentication?.principal ?: throw unauthorized()

        when (principal) {
            is User -> {
                val roles = principal.authorities.map { it.authority }.toTypedArray()
                val accessToken = jwtService.accessToken(principal.username, FOUR_HOURS, roles)
                val refreshToken = jwtService.refreshToken(principal.username, EIGHT_HOURS, roles)
                webFilterExchange?.exchange?.response?.headers?.set("Authorization", accessToken)
                webFilterExchange?.exchange?.response?.headers?.set("JWT-Refresh-Token", refreshToken)
            }
        }

        return@mono null
    }
}