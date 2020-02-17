package com.bymdev.pass2sdk.model.response

data class RefreshTokenResponse(
    val accessToken: String,
    val refreshToken: String
)