package com.bymdev.pass2sdk.model.request

data class CancelOrderItemsRequestBody(
    val orderId: Int,
    val orderItemIds: List<Int>
)