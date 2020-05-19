package com.bymdev.pass2sdk.repository.product

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.addTokenHandler
import com.bymdev.pass2sdk.enums.ProductType
import com.bymdev.pass2sdk.enums.SortBy
import com.bymdev.pass2sdk.enums.SortOrder
import com.bymdev.pass2sdk.model.request.ConfirmPaymentRequestBody
import com.bymdev.pass2sdk.model.request.order.OrderRequestBody
import com.bymdev.pass2sdk.model.response.ProductResponse
import com.bymdev.pass2sdk.model.response.order.OrderCreateResponse
import io.reactivex.Observable

class ProductRepositoryImpl(context: Context) : BaseNetworkRepository(context), ProductRepository {

    private val KEY_VENDOR_CODE = "vendorOwner.code:"
    private val KEY_TYPE = "@type:"
    private val KEY_AND = "AND"
    private val KEY_OR = "OR"
    private val KEY_CATEGORIES = "categories.name:"
    private val KEY_WITHOUT_CATEGORY = "(!_exists_:categories)"

    override fun createOrder(requestBody: OrderRequestBody): Observable<OrderCreateResponse> {
        return restClient.createOrder(requestBody).addTokenHandler(refreshTokenHandler)
    }

    override fun createOrderAsync(requestBody: OrderRequestBody): Observable<OrderCreateResponse> {
        return restClient.createOrderAsync(requestBody).addTokenHandler(refreshTokenHandler)
    }

    override fun getOrderById(id: Int): Observable<OrderCreateResponse> {
        return restClient.getOrderById(id).addTokenHandler(refreshTokenHandler)
    }

    override fun confirmPayment(orderId: Int, paymentId: String): Observable<Unit> {
        return restClient.confirmPayment(ConfirmPaymentRequestBody(orderId, paymentId)).addTokenHandler(refreshTokenHandler)
    }

    override fun getAvailableProducts(
        vendorCode: String?,
        productType: ProductType?,
        page: Int,
        offset: Int,
        query: String?,
        sortBy: SortBy?,
        sortOrder: SortOrder?,
        categories: List<String>?,
        withoutCategory: Boolean?
    ): Observable<List<ProductResponse>> {
        return restClient.getAvailableProducts(getQueryForAvailableProductsRequest(vendorCode, productType, query, categories, withoutCategory),
            page, offset, getSortOrder(sortBy, sortOrder)).addTokenHandler(refreshTokenHandler)
    }

    private fun getSortOrder(sortBy: SortBy?, sortOrder: SortOrder?): String {
        return "${sortBy?.type},${sortOrder?.type}"
    }

    private fun getQueryForAvailableProductsRequest(vendorCode: String?, type: ProductType?, searchedString: String?,
                                                    categories: List<String>?, withoutCategory: Boolean? = false): String? {
        val query = StringBuilder()
        return if(vendorCode == null && type == null && searchedString == null && categories == null) {
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

            if(categories != null || withoutCategory == true) {
                if(vendorCode != null || type != null || searchedString != null) {
                    query.append(" $KEY_AND ")
                }
                query.append(addCategoryFilter(categories, withoutCategory ?: false).toString())
            }

            query.toString()
        }
    }

    private fun addCategoryFilter(categories: List<String>?, withoutCategory: Boolean): StringBuilder {
        val queryBuilder = StringBuilder()
        val hasCategories = categories.isNullOrEmpty().not()
        queryBuilder.append("(")

        if(hasCategories) {
            val categoriesBuilder = StringBuilder()
            categories?.forEach {
                if(categoriesBuilder.isEmpty())
                    categoriesBuilder.append("'$it'")
                else
                    categoriesBuilder.append(" $KEY_OR '$it'")
            }
            queryBuilder.append("$KEY_CATEGORIES($categoriesBuilder) ")
        }

        if(withoutCategory) {
            if(hasCategories)
                queryBuilder.append(KEY_OR)
            queryBuilder.append(" $KEY_WITHOUT_CATEGORY")
        }

        queryBuilder.append(")")

        return queryBuilder
    }
}