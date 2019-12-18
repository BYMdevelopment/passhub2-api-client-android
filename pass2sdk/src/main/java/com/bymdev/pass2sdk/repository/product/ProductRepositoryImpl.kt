package com.bymdev.pass2sdk.repository.product

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.enums.SortOrder
import com.bymdev.pass2sdk.enums.ProductType
import com.bymdev.pass2sdk.enums.SortBy
import com.bymdev.pass2sdk.model.request.order.OrderRequestBody
import com.bymdev.pass2sdk.model.response.ProductResponse
import io.reactivex.Observable

class ProductRepositoryImpl(context: Context) : BaseNetworkRepository(context),
    ProductRepository {

    private val KEY_VENDOR_CODE = "vendorOwner.code:"
    private val KEY_TYPE = "@type:"
    private val KEY_AND = "AND"

    override fun createOrder(requestBody: OrderRequestBody): Observable<Any> {
        return restClient.createOrder(requestBody)
            .applySchedulers()
    }

    override fun getAvailableProducts(
        vendorCode: String?,
        productType: ProductType?,
        page: Int,
        offset: Int,
        query: String?,
        sortBy: SortBy?,
        sortOrder: SortOrder?
    ): Observable<List<ProductResponse>> {
        return restClient.getAvailableProducts(getQueryForAvailableProductsRequest(vendorCode, productType, query), page, offset, getSortOrder(sortBy, sortOrder))
            .applySchedulers()
    }

    private fun getSortOrder(sortBy: SortBy?, sortOrder: SortOrder?): String {
        return "${sortBy?.type},${sortOrder?.type}"
    }

    private fun getQueryForAvailableProductsRequest(vendorCode: String?, type: ProductType?, searchedString: String?): String? {
        var query = StringBuilder()

        return if(vendorCode == null && type == null && searchedString == null) {
            null
        } else {
            if(vendorCode != null) {
                query.append("$KEY_VENDOR_CODE $vendorCode")
            }
            if(type != null) {
                if(vendorCode != null) query.append(" $KEY_AND ")
                query.append("$KEY_TYPE $type")
            }
            if(searchedString != null) {
                if (vendorCode != null || type != null) query.append(" $KEY_AND ")
                query.append("*$searchedString*")
            }

            query.toString()
        }
    }
}