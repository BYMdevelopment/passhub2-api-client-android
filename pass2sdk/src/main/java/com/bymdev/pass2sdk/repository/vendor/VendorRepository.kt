package com.bymdev.pass2sdk.repository.vendor

import com.bymdev.pass2sdk.model.response.vendor.VendorResponse
import io.reactivex.Observable

interface VendorRepository {

    fun getVendorList(): Observable<List<VendorResponse>>

}