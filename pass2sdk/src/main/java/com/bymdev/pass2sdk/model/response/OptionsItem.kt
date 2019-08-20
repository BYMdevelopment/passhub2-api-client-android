package com.bymdev.pass2sdk.model.response

import com.google.gson.annotations.SerializedName

data class OptionsItem(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("additionalInfo")
	val additionalInfo: List<Any?>? = null,

	@field:SerializedName("availabilityConfig")
	val availabilityConfig: AvailabilityConfig? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("validationConfig")
	val validationConfig: ValidationConfig? = null
)