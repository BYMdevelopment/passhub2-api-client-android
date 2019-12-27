package com.bymdev.pass2sdk.model.response.validate

data class Request(
	val customerUid: String? = null,
	val orderId: String? = null,
	val configuration: String? = null,
	val customFields: List<String>? = null,
	val sku: String? = null,
	val voucherCode: String? = null,
	val voucherProductId: String? = null
)
