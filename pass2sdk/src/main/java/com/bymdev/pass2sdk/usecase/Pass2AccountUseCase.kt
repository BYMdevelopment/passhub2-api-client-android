package com.bymdev.pass2sdk.usecase

import android.content.Context
import com.bymdev.pass2sdk.repository.AccountRepositoryImpl

class Pass2AccountUseCase(private val context: Context) {

    fun getAccount() = AccountRepositoryImpl(context).getAccount()

}