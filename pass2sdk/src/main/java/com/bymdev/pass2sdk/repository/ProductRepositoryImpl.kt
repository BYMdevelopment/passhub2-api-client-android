package com.bymdev.pass2sdk.repository

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.model.response.ProductResponse
import io.reactivex.Observable

class ProductRepositoryImpl(context: Context) : BaseNetworkRepository(context), ProductRepository {

    override fun getProductList(offset: Int, page: Int, query: String?, searchByFullQuery: Boolean): Observable<List<ProductResponse>> {

        return restClient
            .getProducts(offset, page, getQuery(query, searchByFullQuery))
            .applySchedulers()
    }

    private fun getQuery(query: String?, searchByFullQuery: Boolean): String {
        return if(query == null) {
            "*"
        } else {
            if(!searchByFullQuery) {
                "*$query*"
            } else {
                query
            }
        }
    }
}