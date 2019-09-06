package com.bymdev.pass2sdk.model.request

data class ValidationRequestBody(val voucherCode: String,
                                 val sku: String?,
                                 val voucherProductId: Int?)