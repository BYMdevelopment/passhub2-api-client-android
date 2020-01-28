package com.bymdev.pass2sdk.model.response.validate

data class ValidationResponse(
	val request: Request? = null,
	val validatedCustomers: List<ValidatedCustomersItem?>? = null,
	val description: String? = null,
	val allowedCustomerCount: List<AllowedCustomerCountItem?>? = null,
	val trxId: String? = null,
	val status: String? = null,
	val errorCode: String? = null,
	val product: Product? = null,
	val products: List<Product>? = null,
	val customers: List<Customer>? = null,
	val orders: List<OrderResponse>? = null
)
