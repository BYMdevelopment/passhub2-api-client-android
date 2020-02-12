package com.bymdev.pass2sdk.repository.account

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.addTokenHandler
import com.bymdev.pass2sdk.model.response.AccountResponse
import io.reactivex.Observable

class AccountRepositoryImpl(context: Context) : BaseNetworkRepository(context), AccountRepository {

    override fun getAccount(): Observable<AccountResponse> {
        return restClient
            .getAccount()
            .addTokenHandler(refreshTokenHandler)
    }

}