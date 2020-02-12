package com.bymdev.pass2sdk.repository.prefs

import com.bymdev.pass2sdk.model.response.auth.Vendor

interface SharedPreferenceRepository {
    fun saveToken(token: String?, refreshToken: String?)
    fun getToken(): String?
    fun getRefreshToken(): String
    fun saveVendor(vendor: Vendor)
    fun getCurrentVendor(): Vendor?
}