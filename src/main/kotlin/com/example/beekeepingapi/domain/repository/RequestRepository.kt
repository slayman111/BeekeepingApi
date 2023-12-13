package com.example.beekeepingapi.domain.repository

import com.example.beekeepingapi.domain.entity.Request
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface RequestRepository : CoroutineCrudRepository<Request, Int>
