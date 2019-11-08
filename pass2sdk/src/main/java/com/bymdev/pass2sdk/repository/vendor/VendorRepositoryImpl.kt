package com.bymdev.pass2sdk.repository.vendor

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.model.response.auth.Vendor
import com.bymdev.pass2sdk.model.response.vendor.VendorResponse
import com.bymdev.pass2sdk.repository.prefs.SharedPreferenceRepositoryImpl
import io.reactivex.Observable

class VendorRepositoryImpl(private val context: Context) : BaseNetworkRepository(context), VendorRepository {

    override fun getVendorList(): Observable<List<VendorResponse>> {
        return restClient.getAvailableVendors()
            .map(this::saveCurrentVendorIfOnlyOne)
            .applySchedulers()
    }

    private fun saveCurrentVendorIfOnlyOne(vendors: List<VendorResponse>): List<VendorResponse> {
        if(vendors.size == 1) {
            SharedPreferenceRepositoryImpl(context).saveVendor(Vendor(vendors[0].code, vendors[0].name))
        }
        return vendors
    }

}