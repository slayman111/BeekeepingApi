package com.example.beekeepingapi.service.security.authentication

import com.example.beekeepingapi.domain.dto.request.LoginRequestDto
import com.example.beekeepingapi.exception.HttpExceptionFactory.badRequest
import jakarta.validation.Validator
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactor.mono
import org.springframework.core.ResolvableType
import org.springframework.http.MediaType
import org.springframework.http.codec.json.AbstractJackson2Decoder
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class JWTConverter(
    private val jacksonDecoder: AbstractJackson2Decoder,
    private val validator: Validator
) : ServerAuthenticationConverter {
    override fun convert(exchange: ServerWebExchange?): Mono<Authentication> = mono {
        val loginRequest = getUsernameAndPassword(exchange!!) ?: throw badRequest()

        if (validator.validate(loginRequest).isNotEmpty()) {
            throw badRequest()
        }

        return@mono UsernamePasswordAuthenticationToken(loginRequest.login, loginRequest.password)
    }

    private suspend fun getUsernameAndPassword(exchange: ServerWebExchange): LoginRequestDto? {
        val dataBuffer = exchange.request.body
        val type = ResolvableType.forClass(LoginRequestDto::class.java)

        return jacksonDecoder
            .decodeToMono(dataBuffer, type, MediaType.APPLICATION_JSON, mapOf())
            .onErrorResume { Mono.empty<LoginRequestDto>() }
            .cast(LoginRequestDto::class.java)
            .awaitFirstOrNull()
    }
}
