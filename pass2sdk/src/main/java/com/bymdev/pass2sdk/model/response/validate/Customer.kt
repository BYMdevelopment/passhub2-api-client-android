package com.bymdev.pass2sdk.model.response.validate

data class Customer(
	val uid: String? = null,
	val firstName: String? = null,
	val lastName: String? = null,
	val phoneNumber: String? = null,
	val email: String? = null,
	val products: List<Product>? = null
)
