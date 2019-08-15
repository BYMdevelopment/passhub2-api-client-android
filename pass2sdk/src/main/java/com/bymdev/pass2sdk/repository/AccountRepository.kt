package com.bymdev.pass2sdk.repository

import com.bymdev.pass2sdk.model.response.AccountResponse
import io.reactivex.Single

interface AccountRepository {

    fun getAccount(): Single<AccountResponse>

}