package com.bymdev.pass2sdk.model.response

import com.google.gson.annotations.SerializedName

data class VendorHolder(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)