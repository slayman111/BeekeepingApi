package com.example.beekeepingapi.domain.repository

import com.example.beekeepingapi.domain.entity.Request
import com.example.beekeepingapi.domain.projection.RequestProjection
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface RequestRepository : CoroutineCrudRepository<Request, Int> {

    companion object {
        private const val FIND_ALL = """
            select 
                r.id request_id, 
                u.id user_id,
                u.full_name user_full_name,
                u.email user_email,
                u.phone_number user_phone_number,
                u.role user_role,
                s.name request_status,
                p.id product_id,
                p.name product_name,
                p.price product_price,
                p_t.name product_type,
                p.image product_image,
                r.amount request_amount,
                extract(epoch from r.delivery_date) * 1000 request_delivery_date,
                extract(epoch from r.created_date) * 1000 request_created_date
            from requests r
                join users u on r.user_id = u.id
                join products p on r.product_id = p.id
                join statuses s on r.status_id = s.id
                join product_types p_t on p.product_type_id = p_t.id
        """
    }

    @Query(FIND_ALL)
    suspend fun findAllProjected(): Flow<RequestProjection>

}
