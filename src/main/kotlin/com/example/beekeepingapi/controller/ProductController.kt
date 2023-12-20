package com.example.beekeepingapi.controller

import com.example.beekeepingapi.domain.dto.response.GetProductResponseDto
import com.example.beekeepingapi.service.ProductService
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.*


@RestController
class ProductController(
    private val productService: ProductService
) {

    @GetMapping("admin/product")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getAll(): Flow<GetProductResponseDto> = productService.getAll()

    @PostMapping(
        value = ["admin/product"],
        consumes = [APPLICATION_JSON_VALUE, MULTIPART_FORM_DATA_VALUE]
    )
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(
        @RequestPart(value = "product") product: String,
        @RequestPart(value = "image", required = false) image: FilePart?
    ): Unit = productService.create(product, image)

    @DeleteMapping("admin/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    suspend fun delete(@PathVariable id: Int): Unit = productService.delete(id)

}