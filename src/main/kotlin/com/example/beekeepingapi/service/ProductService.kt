package com.example.beekeepingapi.service

import com.example.beekeepingapi.domain.dto.request.CreateProductRequestDto
import com.example.beekeepingapi.domain.dto.response.GetProductResponseDto
import com.example.beekeepingapi.domain.entity.Product
import com.example.beekeepingapi.domain.repository.ProductRepository
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.http.codec.multipart.FilePart
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.io.ByteArrayOutputStream

@Service
class ProductService(
    private val objectMapper: ObjectMapper,
    private val productRepository: ProductRepository
) {

    suspend fun create(product: String, image: FilePart?) {
        val createProductRequest: CreateProductRequestDto =
            objectMapper.readValue(product, CreateProductRequestDto::class.java)

        productRepository.save(
            Product(
                name = createProductRequest.name,
                price = createProductRequest.price,
                productTypeId = createProductRequest.productTypeId,
                image = image?.toBytes()
            )
        )
    }

    private suspend fun FilePart.toBytes(): ByteArray {
        val bytesList: List<ByteArray> = this.content()
            .flatMap { dataBuffer -> Flux.just(dataBuffer.asByteBuffer().array()) }
            .collectList()
            .awaitFirst()

        val byteStream = ByteArrayOutputStream()
        bytesList.forEach { bytes -> byteStream.write(bytes) }

        return byteStream.toByteArray()
    }

    suspend fun getAll(): Flow<GetProductResponseDto> =
        productRepository.findAllProjected()
            .map { product ->
                GetProductResponseDto(
                    id = product.id,
                    name = product.name,
                    price = product.price,
                    productType = product.productType,
                    image = product.image
                )
            }

    suspend fun delete(id: Int) = productRepository.deleteById(id)
}
