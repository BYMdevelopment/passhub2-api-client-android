package com.bymdev.pass2sdk.repository

import com.bymdev.pass2sdk.base.ResultRequest
import com.bymdev.pass2sdk.model.response.AuthResponse
import io.reactivex.Single

interface AuthRepository {

    fun signIn(login: String, password: String): Single<ResultRequest<List<AuthResponse>>>

    fun logout(): Single<Unit>

}