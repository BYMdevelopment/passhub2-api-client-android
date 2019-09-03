package com.bymdev.pass2sdk.repository.account

import com.bymdev.pass2sdk.model.response.AccountResponse
import io.reactivex.Observable

interface AccountRepository {

    fun getAccount(): Observable<AccountResponse>

}