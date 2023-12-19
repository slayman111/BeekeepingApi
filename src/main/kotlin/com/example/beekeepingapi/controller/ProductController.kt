package com.example.beekeepingapi.controller

import com.example.beekeepingapi.service.ProductService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.*
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.*


@RestController
class ProductController(
    private val productService: ProductService
) {

    @PostMapping(
        value = ["admin/product"],
        consumes = [APPLICATION_JSON_VALUE, MULTIPART_FORM_DATA_VALUE]
    )
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(
        @RequestPart(value = "product") product: String,
        @RequestPart(value = "image", required = false) image: FilePart
    ) {
        productService.create(product, image)
    }

}