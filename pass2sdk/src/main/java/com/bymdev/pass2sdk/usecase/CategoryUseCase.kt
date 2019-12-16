package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.repository.category.CategoryRepository

class CategoryUseCase(private val repository: CategoryRepository) {

    fun getCategories() = repository.getCategories()

}