package com.bymdev.pass2sdk.model.response

import com.google.gson.annotations.SerializedName

data class Location(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("countryCode")
	val countryCode: String? = null,

	@field:SerializedName("cityCode")
	val cityCode: String? = null,

	@field:SerializedName("timeZone")
	val timeZone: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)