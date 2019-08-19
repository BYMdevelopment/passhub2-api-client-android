package com.bymdev.pass2sdk.repository

import com.bymdev.pass2sdk.model.response.AuthResponse
import io.reactivex.Observable

interface AuthRepository {

    fun signIn(login: String, password: String): Observable<List<AuthResponse>>

    fun logout(): Observable<Unit>

    fun resetPassword(email: String): Observable<Unit>

}