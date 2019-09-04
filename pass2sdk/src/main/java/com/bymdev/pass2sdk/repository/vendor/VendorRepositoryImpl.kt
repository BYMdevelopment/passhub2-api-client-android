package com.bymdev.pass2sdk.repository.vendor

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.model.response.vendor.VendorResponse
import io.reactivex.Observable

class VendorRepositoryImpl(private val context: Context) : BaseNetworkRepository(context), VendorRepository {

    override fun getVendorList(): Observable<List<VendorResponse>> {
        return Observable.just("")
            .flatMap { database.accountDao().getCurrentAccount() }
            .flatMap { restClient.getVendorsList(it.memberId) }
            .applySchedulers()
    }

}