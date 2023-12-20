package com.example.beekeepingapi.domain.repository

import com.example.beekeepingapi.domain.entity.ProductType
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ProductTypeRepository : CoroutineCrudRepository<ProductType, Int>


