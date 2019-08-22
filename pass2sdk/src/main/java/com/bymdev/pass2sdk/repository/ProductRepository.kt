package com.bymdev.pass2sdk.repository

import com.bymdev.pass2sdk.enums.ProductType
import com.bymdev.pass2sdk.model.response.ProductResponse
import io.reactivex.Observable

interface ProductRepository  {

    fun getAvailableProducts(
        vendorCode: String?,
        productType: ProductType?,
        page: Int,
        offset: Int,
        query: String?
    ): Observable<List<ProductResponse>>

}