package com.bymdev.pass2sdk.model.response

import com.google.gson.annotations.SerializedName

data class State(

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("currentStateName")
	val currentStateName: String? = null,

	@field:SerializedName("currentState")
	val currentState: String? = null,

	@field:SerializedName("previousState")
	val previousState: String? = null,

	@field:SerializedName("stateChangedDate")
	val stateChangedDate: String? = null
)