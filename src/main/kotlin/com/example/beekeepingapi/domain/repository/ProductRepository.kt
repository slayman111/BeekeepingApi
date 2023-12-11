package com.example.beekeepingapi.domain.repository

import com.example.beekeepingapi.domain.entity.Product
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ProductRepository : CoroutineCrudRepository<Product, Int>