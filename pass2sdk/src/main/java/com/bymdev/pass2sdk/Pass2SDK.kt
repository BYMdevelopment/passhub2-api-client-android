package com.bymdev.pass2sdk

import android.content.Context
import com.bymdev.pass2sdk.repository.AuthRepositoryImpl
import com.bymdev.pass2sdk.repository.ProductRepositoryImpl
import com.bymdev.pass2sdk.usecase.AccountUseCase
import com.bymdev.pass2sdk.usecase.AuthUseCase
import com.bymdev.pass2sdk.usecase.PrefsUseCase
import com.bymdev.pass2sdk.usecase.ProductUseCase

class Pass2SDK(private val context: Context) {

    private val accountUseCase = AccountUseCase(context)
    private var prefsUseCase: PrefsUseCase = PrefsUseCase(context)
    private val authUseCase = AuthUseCase(AuthRepositoryImpl(context, prefsUseCase))
    private val productUseCase = ProductUseCase(ProductRepositoryImpl(context))

    fun onSignIn(login: String, password: String) = authUseCase.signIn(login, password)
    fun onSignUp(fName: String, lName: String, email: String, password: String, login: String)
            = authUseCase.signUp(fName, lName, email, password, login)
    fun onLogout() = authUseCase.logout()
    fun resetPassword(email: String) = authUseCase.resetPassword(email)

    fun getProductList(offset: Int, page: Int) = productUseCase.getProductList(offset, page)


}