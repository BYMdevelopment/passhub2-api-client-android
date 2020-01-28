package com.bymdev.pass2sdk.model.request

data class ValidationRequestBody(val voucherCode: String,
                                 val sku: String? = null,
                                 val optionCode: String? = null,
                                 val customerUid: String? = null,
                                 val availabilityCode: String? = null,
                                 val orderId: String? = null,
                                 val configuration: ConfigurationRequestBody? = null)