package com.bymdev.pass2sdk.repository

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.model.request.SignInRequestBody
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


}