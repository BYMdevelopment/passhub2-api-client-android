package com.bymdev.pass2sdk.model.response.auth

data class AuthResponse(
	val accessToken: String? = null,
	val refreshToken: String? = null,
	val jsonMemberDefault: String? = null,
	val scope: String? = null,
	val userMemberRelId: String? = null,
	val membership: Membership? = null,
	val tokenType: String? = null,
	val expiresIn: Int? = null,
	val iat: Int? = null,
	val jti: String? = null
)
