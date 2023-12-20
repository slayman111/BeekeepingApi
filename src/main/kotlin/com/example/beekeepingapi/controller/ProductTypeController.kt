package com.example.beekeepingapi.controller

import com.example.beekeepingapi.domain.entity.ProductType
import com.example.beekeepingapi.domain.repository.ProductTypeRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductTypeController(
    private val productTypeRepository: ProductTypeRepository
) {

    @GetMapping("admin/product-type")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getAll(): Flow<ProductType> = productTypeRepository.findAll()

}