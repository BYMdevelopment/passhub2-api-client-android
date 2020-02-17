package com.bymdev.pass2sdk.repository.prefs

import android.content.Context
import com.bymdev.pass2sdk.core.prefs.Pass2PrefsHelper
import com.bymdev.pass2sdk.model.response.auth.Vendor

class SharedPreferenceRepositoryImpl(private val context: Context) : SharedPreferenceRepository {

    override fun saveVendor(vendor: Vendor) {
        Pass2PrefsHelper(context).putCurrentVendor(vendor)
    }

    override fun getCurrentVendor() = Pass2PrefsHelper(context).getCurrentVendor()

    override fun saveToken(token: String?, refreshToken: String?) {
        Pass2PrefsHelper(context).putToken(token, refreshToken)
    }

    override fun getToken() = Pass2PrefsHelper(context).getToken()

    override fun getRefreshToken() = Pass2PrefsHelper(context).getRefreshToken() ?: ""
}