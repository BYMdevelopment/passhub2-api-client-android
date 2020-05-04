package com.bymdev.pass2sdk.model.response

import com.google.gson.annotations.SerializedName

data class VendorConfigurationResponse(
    val code: String,
    val configs: List<ConfigResponse>
)

data class ConfigResponse(
    @SerializedName("@type")
    val type: String,
    @SerializedName("paymentMethods")
    val methods: List<PaymentMethodResponse>
)

data class PaymentMethodResponse(
    @SerializedName("@type")
    val type: String,
    val publicKey: String
)