package com.bymdev.pass2sdk.model.response.convert

data class ConvertResponse(
	val code: String? = null,
	val aliases: Aliases? = null,
	val orderId: Int? = null,
	val id: Int? = null,
	val state: String? = null,
	val vendorHolder: String? = null
)
