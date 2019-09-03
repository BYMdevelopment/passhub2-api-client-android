package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.model.response.vendor.VendorResponse
import com.bymdev.pass2sdk.repository.vendor.VendorRepository
import io.reactivex.Observable

class VendorUseCase(private val vendorRepository: VendorRepository) {

    fun getVendorList(): Observable<List<VendorResponse>> {
        return vendorRepository.getVendorList()
    }

}