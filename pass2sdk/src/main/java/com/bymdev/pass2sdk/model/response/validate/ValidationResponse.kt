package com.bymdev.pass2sdk.model.response.validate

import com.bymdev.pass2sdk.enums.ValidationStatus

data class ValidationResponse(
	val request: Request? = null,
	val validatedCustomers: List<ValidatedCustomersItem?>? = null,
	val description: Any? = null,
	val allowedCustomerCount: List<AllowedCustomerCountItem?>? = null,
	val trxId: String? = null,
	val status: ValidationStatus? = null
)
