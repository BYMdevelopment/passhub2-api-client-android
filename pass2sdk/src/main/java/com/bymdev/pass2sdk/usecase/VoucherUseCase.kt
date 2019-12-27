package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.model.request.ValidationRequestBody
import com.bymdev.pass2sdk.repository.voucher.VoucherRepository

class VoucherUseCase(private val voucherRepository: VoucherRepository) {

    fun validate(requestBody: ValidationRequestBody) = voucherRepository.validate(requestBody)

    fun convert(code: String, newAlias: String, oldAlias: String) = voucherRepository.convert(code, newAlias, oldAlias)

}