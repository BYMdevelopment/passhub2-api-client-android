package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.model.request.ChangePasswordRequestBody
import com.bymdev.pass2sdk.repository.auth.AuthRepository

class AuthUseCase(private val authRepository: AuthRepository)  {

    fun signIn(login: String, password: String) = authRepository.signIn(login, password)

    fun signUp(fName: String, lName: String, login: String, email: String, password: String)
            = authRepository.signUp(fName, lName, login, email, password)

    fun logout() = authRepository.logout()

    fun resetPassword(email: String) = authRepository.resetPassword(email)

    fun changePassword(body: ChangePasswordRequestBody) = authRepository.changePassword(body)

    fun getToken() = authRepository.getToken()

}