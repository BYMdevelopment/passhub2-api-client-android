package com.bymdev.pass2sdk.base

import android.content.Context
import com.bymdev.pass2sdk.core.RefreshTokenHandler
import com.bymdev.pass2sdk.core.RestClient
import com.bymdev.pass2sdk.repository.prefs.SharedPreferenceRepositoryImpl
import com.bymdev.pass2sdk.room.AppDatabase
import io.reactivex.Observable

abstract class BaseNetworkRepository(context: Context) {

    protected val restClient = RestClient.getInstance(context).getService()
    protected val database = AppDatabase.getInstance(context)
    protected val sharedPreferences = SharedPreferenceRepositoryImpl(context)
    protected val refreshTokenHandler = RefreshTokenHandler<Observable<Throwable>>(restClient, sharedPreferences)
}