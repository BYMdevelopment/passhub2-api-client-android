package com.bymdev.pass2sdk.model.response

data class ProductResponse(
	val vendorOwner: VendorOwner? = null,
	val type: String? = null,
	val name: String? = null,
	val options: List<OptionsItem?>? = null,
	val description: String? = null,
	val location: Location? = null,
	val id: Int? = null,
	val state: String? = null,
	val sku: String? = null,
	val vendorHolder: VendorHolder? = null
)
