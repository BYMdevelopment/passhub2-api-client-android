package com.bymdev.pass2sdk.model.response

import com.google.gson.annotations.SerializedName

data class ValidationConfig(

	@field:SerializedName("optionalRulesCnt")
	val optionalRulesCnt: Int? = null,

	@field:SerializedName("requiredRulesCnt")
	val requiredRulesCnt: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("rcGroupCode")
	val rcGroupCode: String? = null
)