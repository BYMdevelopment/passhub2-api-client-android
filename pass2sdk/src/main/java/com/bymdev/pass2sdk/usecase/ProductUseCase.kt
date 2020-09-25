package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.enums.ProductType
import com.bymdev.pass2sdk.enums.SortBy
import com.bymdev.pass2sdk.enums.SortOrder
import com.bymdev.pass2sdk.model.request.order.OrderRequestBody
import com.bymdev.pass2sdk.model.response.orders.OrdersResponse
import com.bymdev.pass2sdk.repository.product.ProductRepository

class ProductUseCase(private val productRepository: ProductRepository) {

    fun getAvailableProducts(vendorCode: String?, productType: ProductType?, page: Int, offset: Int,
                             query: String?, sortBy: SortBy?, sortOrder: SortOrder?, categories: List<String>?,
                             withoutCategory: Boolean? = false)
            = productRepository.getAvailableProducts(vendorCode, productType, page, offset, query, sortBy, sortOrder, categories, withoutCategory)

    fun createOrder(requestBody: OrderRequestBody) = productRepository.createOrder(requestBody)

    fun createOrderAsync(requestBody: OrderRequestBody) = productRepository.createOrderAsync(requestBody)

    fun getOrderById(id: Int) = productRepository.getOrderById(id)

    fun confirmPayment(orderId: Int, paymentId: String) = productRepository.confirmPayment(orderId, paymentId)

    fun sendOrderOnEmail(id: Int, email: String) = productRepository.sendOrderOnEmail(id, email)

    fun getOrders(from: String, till: String? = null, page: Int, query: String?, size: Int, sortOrder: SortOrder, sortOrderField: String)
            = productRepository.getOrders(from, till, page, query, size, sortOrder, sortOrderField)

    fun cancelOrder(body: OrdersResponse) = productRepository.cancelOrder(body)

}