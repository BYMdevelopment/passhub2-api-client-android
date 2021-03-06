package com.bymdev.pass2sdk

import android.content.Context
import com.bymdev.pass2sdk.repository.AuthRepositoryImpl
import com.bymdev.pass2sdk.usecase.Pass2AccountUseCase
import com.bymdev.pass2sdk.usecase.Pass2AuthUseCase
import com.bymdev.pass2sdk.usecase.Pass2PrefsUseCase

class Pass2SDK(private val context: Context) {

    private val accountUseCase = Pass2AccountUseCase(context)
    private var prefsUseCase: Pass2PrefsUseCase = Pass2PrefsUseCase(context)
    private val authUseCase = Pass2AuthUseCase(AuthRepositoryImpl(context, prefsUseCase))

    fun onSignIn(login: String, password: String) = authUseCase.signIn(login, password)
    fun onSignUp(fName: String, lName: String, email: String, password: String, login: String)
            = authUseCase.signUp(fName, lName, email, password, login)
    fun onLogout() = authUseCase.logout()
    fun resetPassword(email: String) = authUseCase.resetPassword(email)

}