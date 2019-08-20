package com.bymdev.pass2sdk.model.response

import com.google.gson.annotations.SerializedName

data class ProductResponse(

	@field:SerializedName("vendorOwner")
	val vendorOwner: VendorOwner? = null,

	@field:SerializedName("@type")
	val type: String? = null,

	@field:SerializedName("lastChangeDate")
	val lastChangeDate: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("creationDate")
	val creationDate: String? = null,

	@field:SerializedName("vendorHolder")
	val vendorHolder: VendorHolder? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null,

	@field:SerializedName("createdBy")
	val createdBy: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("options")
	val options: List<OptionsItem?>? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("state")
	val state: State? = null,

	@field:SerializedName("categories")
	val categories: List<Any?>? = null,

	@field:SerializedName("sku")
	val sku: String? = null,

	@field:SerializedName("lastChangedBy")
	val lastChangedBy: String? = null
)