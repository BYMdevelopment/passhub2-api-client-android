package com.bymdev.pass2sdk.core

import android.content.Context
import com.bymdev.pass2sdk.core.prefs.Pass2PrefsHelper

class AuthTokenProviderImpl(private val context: Context) : AuthTokenProvider {

    override fun getToken() : String? {
        return Pass2PrefsHelper(context).getToken()
    }

}