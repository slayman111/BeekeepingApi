package com.example.beekeepingapi.controller

import com.example.beekeepingapi.domain.entity.User
import com.example.beekeepingapi.service.UserService
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("admin/user")
    suspend fun getAll(): Flow<User> =
        userService.findAll()

    @DeleteMapping("admin/user/{id}")
    suspend fun delete(@PathVariable id: Int): Unit =
        userService.deleteById(id)

}