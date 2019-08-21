package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.repository.ProductRepository

class ProductUseCase(private val productRepository: ProductRepository) {

    fun getProductList(offset: Int, page: Int, query: String?) = productRepository.getProductList(offset, page, query)

}