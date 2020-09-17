package com.bymdev.pass2sdk.repository.auth

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.addTokenHandler
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.model.request.ChangePasswordRequestBody
import com.bymdev.pass2sdk.model.request.ResetPasswordRequestBody
import com.bymdev.pass2sdk.model.request.SignInRequestBody
import com.bymdev.pass2sdk.model.request.SignUpRequestBody
import com.bymdev.pass2sdk.model.response.auth.AuthResponse
import com.bymdev.pass2sdk.room.entity.AccountEntity
import com.bymdev.pass2sdk.usecase.PrefsUseCase
import io.reactivex.Observable
import io.reactivex.Single

class AuthRepositoryImpl(context: Context,
                         private val prefsUseCase: PrefsUseCase) : BaseNetworkRepository(context), AuthRepository {

    override fun logout(): Single<Unit> {
        return restClient
            .logout()
            .map { prefsUseCase.putToken(null, null) }
            .map { database.accountDao().delete() }
            .applySchedulers()
    }

    override fun signIn(login: String, password: String): Observable<List<AuthResponse>> {
        return restClient
            .signIn(SignInRequestBody(login, password))
            .doOnSubscribe { database.accountDao().delete() }
            .map { items ->
                if(!items.isNullOrEmpty()) {
                    items.map {
                        AccountEntity(it.user_member_rel_id ?: "", it.access_token ?: "",
                            it.refresh_token ?: "", it.membership?.name, it.default)
                    }.map {
                        database.accountDao().insert(it)
                        if(it.isDefault) {
                            prefsUseCase.putToken(it.token, it.refresh_token)
                        }
                    }
                }
                items
            }.applySchedulers()
    }

    override fun signUp(fName: String, lName: String, login: String, email: String, password: String): Observable<Unit> {
        return restClient
            .signUp(SignUpRequestBody(fName, lName, login, email, password))
            .applySchedulers()
    }

    override fun resetPassword(email: String): Observable<Unit> {
        return restClient
            .resetPassword(ResetPasswordRequestBody(email))
            .applySchedulers()
    }

    override fun changePassword(body: ChangePasswordRequestBody): Observable<Unit> {
        return restClient
            .changePassword(body)
            .addTokenHandler(refreshTokenHandler)
    }

    override fun getToken() = prefsUseCase.getToken()

}