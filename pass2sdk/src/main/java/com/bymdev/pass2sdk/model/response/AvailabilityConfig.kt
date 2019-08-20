package com.bymdev.pass2sdk.model.response

import com.google.gson.annotations.SerializedName

data class AvailabilityConfig(

	@field:SerializedName("optionAvailabilities")
	val optionAvailabilities: List<OptionAvailabilitiesItem?>? = null,

	@field:SerializedName("id")
	val id: Int? = null
)