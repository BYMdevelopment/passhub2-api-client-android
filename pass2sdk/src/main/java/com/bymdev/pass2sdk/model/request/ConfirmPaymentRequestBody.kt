package com.bymdev.pass2sdk.model.request

data class ConfirmPaymentRequestBody(
    val orderId: Int,
    val paymentId: String
)