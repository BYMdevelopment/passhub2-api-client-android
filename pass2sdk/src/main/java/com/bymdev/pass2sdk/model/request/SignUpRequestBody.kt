package com.bymdev.pass2sdk.model.request

data class SignUpRequestBody(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val login: String
)