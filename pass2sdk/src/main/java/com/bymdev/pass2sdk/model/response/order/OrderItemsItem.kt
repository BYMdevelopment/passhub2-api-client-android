package com.bymdev.pass2sdk.model.response.order

data class OrderItemsItem(
	val product: Product? = null,
	val quantity: Int? = null,
	val customFields: List<Any?>? = null,
	val itemTotalPrice: Double? = null,
	val availabilityCode: String? = null,
	val voucherAliases: List<Any?>? = null,
	val optionCode: String? = null,
	val voucherId: String? = null,
	val id: Int? = null,
	val state: String? = null,
	val pricePaid: Any? = null,
	val sku: String? = null,
	val productPrice: Double? = null,
	val groupCode: String? = null,
	val customer: Customer? = null
)
