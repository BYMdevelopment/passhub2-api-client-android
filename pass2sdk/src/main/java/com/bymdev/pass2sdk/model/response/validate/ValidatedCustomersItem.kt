package com.bymdev.pass2sdk.model.response.validate

data class ValidatedCustomersItem(
	val validatedProducts: List<ValidatedProductsItem?>? = null,
	val customer: Customer? = null
)
