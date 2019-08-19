package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.repository.AuthRepository
import io.reactivex.Observable

class Pass2AuthUseCase(private val authRepository: AuthRepository)  {

    fun signIn(login: String, password: String) = authRepository.signIn(login, password)

    fun signUp(fName: String, lName: String, email: String, password: String, login: String)
            = authRepository.signUp(fName, lName, email, password, login)

    fun logout() = authRepository.logout()

    fun resetPassword(email: String): Observable<Unit> = authRepository.resetPassword(email)

}