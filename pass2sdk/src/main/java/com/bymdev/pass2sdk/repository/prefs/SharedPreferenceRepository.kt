package com.bymdev.pass2sdk.repository.prefs

import com.bymdev.pass2sdk.model.response.auth.Vendor

interface SharedPreferenceRepository {
    fun saveToken(token: String?)
    fun getToken(): String?
    fun saveVendor(vendor: Vendor)
    fun getCurrentVendor(): Vendor?
}