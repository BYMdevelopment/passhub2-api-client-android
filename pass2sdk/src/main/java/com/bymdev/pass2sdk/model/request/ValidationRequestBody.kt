package com.bymdev.pass2sdk.model.request

data class ValidationRequestBody(val voucherCode: String,
                                 val sku: String?,
                                 val optionCode: String?,
                                 val customerUid: String?,
                                 val availabilityCode: String?,
                                 val configuration: ConfigurationRequestBody?)