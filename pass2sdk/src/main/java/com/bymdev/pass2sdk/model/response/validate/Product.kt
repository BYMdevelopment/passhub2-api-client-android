package com.bymdev.pass2sdk.model.response.validate

data class Product(
	val customerTypeName: String? = null,
	val customerType: String? = null,
	val optionCode: String? = null,
	val orderId: Int? = null,
	val name: String? = null,
	val id: Int? = null,
	val sku: String? = null,
	val optionName: String? = null,
	val availabilities: List<ProductAvailability>?
)
