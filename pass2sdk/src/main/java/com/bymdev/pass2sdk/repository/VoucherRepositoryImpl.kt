package com.bymdev.pass2sdk.repository

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.model.request.ValidationRequestBody
import com.bymdev.pass2sdk.model.response.validate.ValidationResponse
import io.reactivex.Observable

class VoucherRepositoryImpl(private val context: Context) : BaseNetworkRepository(context), VoucherRepository {

    override fun validate(voucherCode: String): Observable<ValidationResponse> {
        return restClient
            .validate(voucherCode, ValidationRequestBody(voucherCode))
            .applySchedulers()
    }

}