package com.bymdev.pass2sdk.model.response.order

data class State(
	val description: String? = null,
	val currentState: String? = null,
	val previousState: String? = null,
	val stateChangedDate: String? = null
)
