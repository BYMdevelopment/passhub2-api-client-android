package com.bymdev.pass2sdk.repository.product

import com.bymdev.pass2sdk.enums.ProductType
import com.bymdev.pass2sdk.enums.SortBy
import com.bymdev.pass2sdk.enums.SortOrder
import com.bymdev.pass2sdk.model.request.order.OrderRequestBody
import com.bymdev.pass2sdk.model.response.ProductResponse
import com.bymdev.pass2sdk.model.response.order.OrderCreateResponse
import com.bymdev.pass2sdk.model.response.orders.OrdersResponse
import io.reactivex.Observable

interface ProductRepository  {

    fun getAvailableProducts(
        vendorCode: String?,
        productType: ProductType?,
        page: Int,
        offset: Int,
        query: String?,
        sortBy: SortBy?,
        sortOrder: SortOrder?,
        categories: List<String>?,
        withoutCategory: Boolean? = false
    ): Observable<List<ProductResponse>>

    fun createOrder(requestBody: OrderRequestBody): Observable<OrderCreateResponse>

    fun createOrderAsync(requestBody: OrderRequestBody): Observable<OrderCreateResponse>

    fun getOrderById(id: Int): Observable<OrderCreateResponse>

    fun confirmPayment(orderId: Int, paymentId: String): Observable<Unit>

    fun sendOrderOnEmail(id: Int, email: String): Observable<Unit>

    fun getOrders(from: String, till: String? = null, page: Int, query: String?, size: Int, sortOrder: SortOrder, sortOrderField: String): Observable<List<OrdersResponse>>

    fun cancelOrder(body: OrdersResponse): Observable<OrdersResponse>
}