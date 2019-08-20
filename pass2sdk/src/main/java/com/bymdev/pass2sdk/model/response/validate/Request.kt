package com.bymdev.pass2sdk.model.response.validate

data class Request(
	val customerUid: Any? = null,
	val orderId: Any? = null,
	val configuration: Any? = null,
	val customFields: Any? = null,
	val sku: Any? = null,
	val voucherCode: String? = null,
	val voucherProductId: Any? = null
)
