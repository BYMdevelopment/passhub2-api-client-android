package com.bymdev.pass2sdk.repository

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.ResultRequest
import com.bymdev.pass2sdk.core.KEY_EMPTY_TOKEN_CODE
import com.bymdev.pass2sdk.core.KEY_EMPTY_TOKEN_MSG
import com.bymdev.pass2sdk.core.KEY_UNKNOWN_ERROR_CODE
import com.bymdev.pass2sdk.core.KEY_UNKNOWN_ERROR_MSG
import com.bymdev.pass2sdk.model.request.SignInRequestBody
import com.bymdev.pass2sdk.model.response.AuthResponse
import com.bymdev.pass2sdk.usecase.Pass2PrefsUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AuthRepositoryImpl(private val context: Context,
                         private val prefsUseCase: Pass2PrefsUseCase) : BaseNetworkRepository(context), AuthRepository {

    override fun logout(): Single<Unit> {
        return restClient
            .logout()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun signIn(login: String, password: String): Single<ResultRequest<List<AuthResponse>>> {
        return restClient
            .signIn(SignInRequestBody(login, password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                if(!it.isNullOrEmpty() && it[0].token != null) {
                    prefsUseCase.putToken(it[0].token)
                    ResultRequest.fromData(it)
                } else {
                    ResultRequest.fromError(KEY_EMPTY_TOKEN_CODE, KEY_EMPTY_TOKEN_MSG)
                }
            }.onErrorReturn {
                ResultRequest.fromError(KEY_UNKNOWN_ERROR_CODE, KEY_UNKNOWN_ERROR_MSG)
            }
    }


}