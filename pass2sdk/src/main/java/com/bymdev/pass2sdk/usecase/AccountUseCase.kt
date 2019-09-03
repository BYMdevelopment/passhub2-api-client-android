package com.bymdev.pass2sdk.usecase

import android.content.Context
import com.bymdev.pass2sdk.repository.account.AccountRepositoryImpl

class AccountUseCase(private val context: Context) {

    fun getAccount() = AccountRepositoryImpl(context).getAccount()

}