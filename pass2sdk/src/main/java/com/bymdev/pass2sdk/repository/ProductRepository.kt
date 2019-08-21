package com.bymdev.pass2sdk.repository

import com.bymdev.pass2sdk.model.response.ProductResponse
import io.reactivex.Observable

interface ProductRepository  {
    fun getProductList(offset: Int, page: Int, query: String?, searchByFullQuery: Boolean = false): Observable<List<ProductResponse>>
}