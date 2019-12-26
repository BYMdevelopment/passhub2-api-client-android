package com.bymdev.pass2sdk.repository.category

import com.bymdev.pass2sdk.model.CategoryResponse
import io.reactivex.Observable

interface CategoryRepository {
    fun getCategories(page: Int, size: Int, sortOrder: String): Observable<List<CategoryResponse>>
}