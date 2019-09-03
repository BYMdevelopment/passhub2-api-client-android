package com.bymdev.pass2sdk.repository.prefs

import android.content.Context
import com.bymdev.pass2sdk.core.prefs.Pass2PrefsHelper

class SharedPreferenceRepositoryImpl(private val context: Context) :
    SharedPreferenceRepository {

    override fun saveToken(token: String?) {
        Pass2PrefsHelper(context).putToken(token)
    }

    override fun getToken() = Pass2PrefsHelper(context).getToken()

}