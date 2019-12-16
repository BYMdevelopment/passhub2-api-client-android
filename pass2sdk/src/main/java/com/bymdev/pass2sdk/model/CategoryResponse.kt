package com.bymdev.pass2sdk.model

data class CategoryResponse(
    val id: Long,
    val code: String,
    val childCategories: List<CategoryResponse>
)