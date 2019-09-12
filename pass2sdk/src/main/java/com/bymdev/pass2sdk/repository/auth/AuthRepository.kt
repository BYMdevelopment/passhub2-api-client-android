package com.bymdev.pass2sdk.repository.auth

import com.bymdev.pass2sdk.model.response.auth.AuthResponse
import io.reactivex.Observable
import io.reactivex.Single

interface AuthRepository {

    fun signIn(login: String, password: String): Observable<List<AuthResponse>>

    fun signUp(fName: String, lName: String, login: String, email: String, password: String): Observable<Unit>

    fun logout(): Single<Unit>

    fun resetPassword(email: String): Observable<Unit>

    fun changePassword(password: String): Observable<Unit>

    fun getToken(): String?

}