package com.example.beekeepingapi.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

object HttpExceptionFactory {

    fun badRequest(): ResponseStatusException = ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request")

    fun unauthorized(): ResponseStatusException = ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized")

    fun loginAlreadyExists(): ResponseStatusException =
        ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Unprocessable Entity")

}