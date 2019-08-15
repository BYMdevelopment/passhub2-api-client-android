package com.bymdev.pass2sdk.repository

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.model.response.AccountResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AccountRepositoryImpl(context: Context) : BaseNetworkRepository(context), AccountRepository {

    override fun getAccount(): Single<AccountResponse> {
        return restClient
            .getAccount()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}