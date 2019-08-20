package com.bymdev.pass2sdk.model.response

import com.google.gson.annotations.SerializedName

data class AuthResponse(

    @field:SerializedName("ValidationStatus")
    val status: String? = null,

    @field:SerializedName("access_token")
    val token: String? = null
)