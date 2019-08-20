package com.bymdev.pass2sdk.repository

import com.bymdev.pass2sdk.model.response.validate.ValidationResponse
import io.reactivex.Observable

interface VoucherRepository {
    fun validate(voucherCode: String): Observable<ValidationResponse>
}