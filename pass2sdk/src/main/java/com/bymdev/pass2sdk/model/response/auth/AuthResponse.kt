package com.bymdev.pass2sdk.model.response.auth

data class AuthResponse(
	val access_token: String? = null,
	val refresh_token: String? = null,
	val jsonMemberDefault: String? = null,
	val scope: String? = null,
	val user_member_rel_id: String? = null,
	val membership: Membership? = null,
	val token_type: String? = null,
	val expires_in: Int? = null,
	val iat: Int? = null,
	val jti: String? = null
)
