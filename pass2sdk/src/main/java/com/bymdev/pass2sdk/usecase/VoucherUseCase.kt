package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.repository.VoucherRepository

class VoucherUseCase(private val voucherRepository: VoucherRepository) {

    fun validate(voucherCode: String) = voucherRepository.validate(voucherCode)

}