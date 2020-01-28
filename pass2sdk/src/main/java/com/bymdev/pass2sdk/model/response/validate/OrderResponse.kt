package com.bymdev.pass2sdk.model.response.validate

data class OrderResponse(
    val id: Int?,
    val customers: List<Customer>? = null
)