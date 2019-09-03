package com.bymdev.pass2sdk.base

import android.content.Context
import com.bymdev.pass2sdk.core.RestClient
import com.bymdev.pass2sdk.repository.prefs.SharedPreferenceRepositoryImpl
import com.bymdev.pass2sdk.room.AppDatabase

abstract class BaseNetworkRepository(context: Context) {

    val restClient = RestClient.getInstance(context).getService()
    val database = AppDatabase.getInstance(context)
    val sharedPreferences =
        SharedPreferenceRepositoryImpl(context)
}