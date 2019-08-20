package com.bymdev.pass2sdk.repository

interface VoucherRepository {
    fun validate(voucherCode: String)
}