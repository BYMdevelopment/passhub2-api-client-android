package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.enums.ProductType
import com.bymdev.pass2sdk.repository.ProductRepository

class ProductUseCase(private val productRepository: ProductRepository) {

    fun getAvailableProducts(vendorCode: String?, productType: ProductType?, page: Int, offset: Int, query: String?)
            = productRepository.getAvailableProducts(vendorCode, productType, page, offset, query)

}