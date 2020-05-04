package com.bymdev.pass2sdk.repository.vendor

import com.bymdev.pass2sdk.model.response.VendorConfigurationResponse
import com.bymdev.pass2sdk.model.response.vendor.VendorResponse
import io.reactivex.Observable

interface VendorRepository {

    fun getVendorList(): Observable<List<VendorResponse>>

    fun setCurrentVendor(code: String, name: String)

    fun checkVendorConfiguration(): Observable<List<VendorConfigurationResponse>>

}