package com.bymdev.pass2sdk.repository.category

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.model.CategoryResponse
import io.reactivex.Observable

class CategoryRepositoryImpl(val context: Context) : BaseNetworkRepository(context), CategoryRepository {

    override fun getCategories(): Observable<List<CategoryResponse>> {
        return restClient.getCategories()
            .applySchedulers()
    }

}