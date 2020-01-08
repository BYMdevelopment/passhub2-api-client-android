package com.bymdev.pass2sdk.model.response.order

data class OrderCreateResponse(
	val createdBy: String? = null,
	val price: Double? = null,
	val customFields: List<Any?>? = null,
	val lastChangeDate: String? = null,
	val id: Int? = null,
	val state: State? = null,
	val creationDate: String? = null,
	val lastChangedBy: String? = null,
	val orderItems: List<OrderItemsItem?>? = null,
	val vendorHolder: VendorHolder? = null
)
