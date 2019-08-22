package com.bymdev.pass2sdk.model.response

data class OptionsItem(
	val code: String? = null,
	val availabilities: List<AvailabilitiesItem?>? = null,
	val name: String? = null,
	val additionalInfo: Any? = null,
	val id: Int? = null
)
