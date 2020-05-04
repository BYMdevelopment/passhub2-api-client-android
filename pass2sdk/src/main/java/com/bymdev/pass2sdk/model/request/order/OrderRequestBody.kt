package com.bymdev.pass2sdk.model.request.order

data class OrderRequestBody(
    val paymentInfo: PaymentInfoRequestBody,
    val orderItems: List<OrderItemRequestBody>
)