package com.bymdev.pass2sdk.model.response.order

data class Product(
	val customerType: String? = null,
	val optionCode: String? = null,
	val vendorOwner: VendorOwner? = null,
	val type: String? = null,
	val price: Double? = null,
	val name: String? = null,
	val availabilityCode: String? = null,
	val structureId: Any? = null,
	val id: Int? = null,
	val sku: String? = null,
	val optionName: String? = null,
	val rcGroupCode: Any? = null
)
