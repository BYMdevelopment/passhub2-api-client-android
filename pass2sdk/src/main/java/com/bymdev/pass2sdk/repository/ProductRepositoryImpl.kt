package com.bymdev.pass2sdk.repository

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.model.response.ProductResponse
import io.reactivex.Observable

class ProductRepositoryImpl(context: Context) : BaseNetworkRepository(context), ProductRepository {

    override fun getProductList(offset: Int, page: Int): Observable<List<ProductResponse>> {
        return restClient
            .getProducts(offset, page)
            .applySchedulers()
    }

}