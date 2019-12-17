package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.enums.AscType
import com.bymdev.pass2sdk.enums.ProductType
import com.bymdev.pass2sdk.enums.SortType
import com.bymdev.pass2sdk.model.request.order.OrderRequestBody
import com.bymdev.pass2sdk.repository.product.ProductRepository

class ProductUseCase(private val productRepository: ProductRepository) {

    fun getAvailableProducts(vendorCode: String?, productType: ProductType?, page: Int, offset: Int,
                             query: String?, sort: SortType?, ascType: AscType?)
            = productRepository.getAvailableProducts(vendorCode, productType, page, offset, query, sort, ascType)

    fun createOrder(requestBody: OrderRequestBody) = productRepository.createOrder(requestBody)

}