package com.bymdev.pass2sdk.repository.vendor

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.addTokenHandler
import com.bymdev.pass2sdk.model.response.auth.Vendor
import com.bymdev.pass2sdk.model.response.vendor.VendorResponse
import com.bymdev.pass2sdk.repository.prefs.SharedPreferenceRepositoryImpl
import io.reactivex.Observable

class VendorRepositoryImpl(private val context: Context) : BaseNetworkRepository(context), VendorRepository {

    override fun getVendorList(): Observable<List<VendorResponse>> {
        return restClient.getAvailableVendors()
            .map(this::saveCurrentVendorIfOnlyOne)
            .addTokenHandler(refreshTokenHandler)
    }

    private fun saveCurrentVendorIfOnlyOne(vendors: List<VendorResponse>): List<VendorResponse> {
        if(vendors.isNotEmpty()) {
            val currentVendor = vendors.first()
            SharedPreferenceRepositoryImpl(context).saveVendor(Vendor(currentVendor.code, currentVendor.name))
        }
        return vendors
    }

}