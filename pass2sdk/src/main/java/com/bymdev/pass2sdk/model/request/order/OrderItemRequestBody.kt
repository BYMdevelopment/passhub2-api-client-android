package com.bymdev.pass2sdk.model.request.order

data class OrderItemRequestBody(
	val quantity: Int? = null,
	val optionCode: String? = null,
	val availabilityCode: String? = null,
	val sku: String? = null,
	val voucherPerPerson: Boolean = false
)
