package com.example.beekeepingapi.domain.repository

import com.example.beekeepingapi.domain.entity.Product
import com.example.beekeepingapi.domain.projection.ProductProjection
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ProductRepository : CoroutineCrudRepository<Product, Int> {

    companion object {
        private const val FIND_ALL = """
            select 
                p.*, 
                pt.name product_type
            from products p
                join product_types pt on p.product_type_id = pt.id
        """
    }

    @Query(FIND_ALL)
    suspend fun findAllProjected(): Flow<ProductProjection>

}