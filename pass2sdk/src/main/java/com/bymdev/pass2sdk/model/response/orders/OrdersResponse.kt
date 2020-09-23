package com.bymdev.pass2sdk.model.response.orders

import com.google.gson.annotations.SerializedName

data class OrdersResponse(

	@field:SerializedName("createdBy")
	val createdBy: String? = null,

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("customFields")
	val customFields: List<Any?>? = null,

	@field:SerializedName("lastChangeDate")
	val lastChangeDate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("state")
	val state: State? = null,

	@field:SerializedName("creationDate")
	val creationDate: String? = null,

	@field:SerializedName("lastChangedBy")
	val lastChangedBy: String? = null,

	@field:SerializedName("orderItems")
	val orderItems: List<OrderItemsItem?>? = null,

	@field:SerializedName("vendorHolder")
	val vendorHolder: VendorHolder? = null
)

data class VendorOwner(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)

data class OrderItemsItem(

	@field:SerializedName("product")
	val product: Product? = null,

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("customFields")
	val customFields: List<Any?>? = null,

	@field:SerializedName("itemTotalPrice")
	val itemTotalPrice: Double? = null,

	@field:SerializedName("availabilityCode")
	val availabilityCode: String? = null,

	@field:SerializedName("voucherAliases")
	val voucherAliases: List<Any?>? = null,

	@field:SerializedName("voucherPerPerson")
	val voucherPerPerson: Boolean? = null,

	@field:SerializedName("optionCode")
	val optionCode: String? = null,

	@field:SerializedName("voucherId")
	val voucherId: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("sku")
	val sku: String? = null,

	@field:SerializedName("productPrice")
	val productPrice: Double? = null,

	@field:SerializedName("groupCode")
	val groupCode: String? = null,

	@field:SerializedName("customer")
	val customer: Customer? = null
)

data class Product(

	@field:SerializedName("images")
	val images: List<Any?>? = null,

	@field:SerializedName("customerType")
	val customerType: String? = null,

	@field:SerializedName("optionCode")
	val optionCode: String? = null,

	@field:SerializedName("vendorOwner")
	val vendorOwner: VendorOwner? = null,

	@field:SerializedName("@type")
	val type: String? = null,

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("availabilityCode")
	val availabilityCode: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("sku")
	val sku: String? = null,

	@field:SerializedName("optionName")
	val optionName: String? = null
)

data class Customer(

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("profileId")
	val profileId: String? = null
)

data class State(

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("currentState")
	val currentState: String? = null,

	@field:SerializedName("previousState")
	val previousState: String? = null,

	@field:SerializedName("stateChangedDate")
	val stateChangedDate: String? = null
)

data class VendorHolder(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)
