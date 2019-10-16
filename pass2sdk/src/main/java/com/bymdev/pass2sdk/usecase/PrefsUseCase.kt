package com.bymdev.pass2sdk.usecase

import android.content.Context
import com.bymdev.pass2sdk.model.response.auth.Vendor
import com.bymdev.pass2sdk.repository.prefs.SharedPreferenceRepositoryImpl

class PrefsUseCase(private val context: Context) {

    fun putToken(token: String?) = SharedPreferenceRepositoryImpl(
        context
    ).saveToken(token)

    fun getToken() = SharedPreferenceRepositoryImpl(context).getToken()

    fun putCurrentVendor(vendor: Vendor) = SharedPreferenceRepositoryImpl(context).saveVendor(vendor)

    fun getCurrentVendor() = SharedPreferenceRepositoryImpl(context).getCurrentVendor()

}