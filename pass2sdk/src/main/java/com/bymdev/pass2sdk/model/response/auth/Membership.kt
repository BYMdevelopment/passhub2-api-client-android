package com.bymdev.pass2sdk.model.response.auth

data class Membership(
	val role: Role? = null,
	val vendor: Vendor? = null,
	val name: String? = null,
	val type: String? = null
)
