package com.bymdev.pass2sdk.repository.product

import com.bymdev.pass2sdk.enums.AscType
import com.bymdev.pass2sdk.enums.ProductType
import com.bymdev.pass2sdk.enums.SortType
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
        sort: SortType?,
        ascType: AscType?
    ): Observable<List<ProductResponse>>

    fun createOrder(requestBody: OrderRequestBody): Observable<Any>

}