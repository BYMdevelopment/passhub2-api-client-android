package com.bymdev.pass2sdk.usecase

import android.content.Context
import com.bymdev.pass2sdk.repository.SharedPreferenceRepositoryImpl

class PrefsUseCase(private val context: Context) {

    fun putToken(token: String?) {
        SharedPreferenceRepositoryImpl(context).saveToken(token)
    }

}