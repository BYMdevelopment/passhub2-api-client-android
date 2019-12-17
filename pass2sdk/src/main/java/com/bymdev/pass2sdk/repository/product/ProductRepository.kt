package com.bymdev.pass2sdk.repository.product

import com.bymdev.pass2sdk.enums.SortOrder
import com.bymdev.pass2sdk.enums.ProductType
import com.bymdev.pass2sdk.enums.SortBy
import com.bymdev.pass2sdk.model.request.order.OrderRequestBody
import com.bymdev.pass2sdk.model.response.ProductResponse
import io.reactivex.Observable

interface ProductRepository  {

    fun getAvailableProducts(
        vendorCode: String?,
        productType: ProductType?,
        page: Int,
        offset: Int,
        query: String?,
        sort: SortBy?,
        sortOrder: SortOrder?
    ): Observable<List<ProductResponse>>

    fun createOrder(requestBody: OrderRequestBody): Observable<Any>

}