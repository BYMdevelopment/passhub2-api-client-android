package com.bymdev.pass2sdk.repository

import com.bymdev.pass2sdk.model.response.auth.AuthResponse
import io.reactivex.Observable

interface AuthRepository {

    fun signIn(login: String, password: String): Observable<List<AuthResponse>>

    fun signUp(fName: String, lName: String, email: String, password: String, login: String): Observable<Unit>

    fun logout(): Observable<Unit>

    fun resetPassword(email: String): Observable<Unit>

}