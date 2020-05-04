package com.bymdev.pass2sdk.model.response.order

data class PaymentInfo(
    val type: String,
    val clientSecret: String
)