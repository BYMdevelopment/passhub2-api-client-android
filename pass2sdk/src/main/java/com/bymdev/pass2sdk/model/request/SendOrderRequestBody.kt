package com.bymdev.pass2sdk.model.request

import com.google.gson.annotations.SerializedName

data class SendOrderRequestBody(
    val email: String,
    @SerializedName("@type")
    private val type: String = "EmailDelivery"
)