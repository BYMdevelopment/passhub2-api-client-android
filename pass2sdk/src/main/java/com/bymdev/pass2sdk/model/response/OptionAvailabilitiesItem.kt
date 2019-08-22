package com.bymdev.pass2sdk.model.response

import com.google.gson.annotations.SerializedName

data class OptionAvailabilitiesItem(

	@field:SerializedName("customerType")
	val customerType: String? = null,

	@field:SerializedName("isStatic")
	val isStatic: Boolean? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("price")
	val price: Int? = null
)