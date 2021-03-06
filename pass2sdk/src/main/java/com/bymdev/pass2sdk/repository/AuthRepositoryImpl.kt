package com.bymdev.pass2sdk.repository

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.model.request.ResetPasswordRequestBody
import com.bymdev.pass2sdk.model.request.SignInRequestBody
import com.bymdev.pass2sdk.model.request.SignUpRequestBody
import com.bymdev.pass2sdk.model.response.AuthResponse
import com.bymdev.pass2sdk.usecase.Pass2PrefsUseCase
import io.reactivex.Observable

class AuthRepositoryImpl(private val context: Context,
                         private val prefsUseCase: Pass2PrefsUseCase) : BaseNetworkRepository(context), AuthRepository {

    override fun logout(): Observable<Unit> {
        return restClient
            .logout()
            .applySchedulers()
    }

    override fun signIn(login: String, password: String): Observable<List<AuthResponse>> {
        return restClient
            .signIn(SignInRequestBody(login, password))
            .applySchedulers()
    }

    override fun signUp(fName: String, lName: String, email: String, password: String, login: String): Observable<Unit> {
        return restClient
            .signUp(SignUpRequestBody(fName, lName, email, password, login))
            .applySchedulers()
    }

    override fun resetPassword(email: String): Observable<Unit> {
        return restClient
            .resetPassword(ResetPasswordRequestBody(email))
            .applySchedulers()
    }

}