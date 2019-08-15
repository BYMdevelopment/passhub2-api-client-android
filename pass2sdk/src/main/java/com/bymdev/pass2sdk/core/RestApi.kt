package com.bymdev.pass2sdk.core

import com.bymdev.pass2sdk.model.request.SignInRequestBody
import com.bymdev.pass2sdk.model.response.AccountResponse
import com.bymdev.pass2sdk.model.response.AuthResponse
import io.reactivex.Single
import retrofit2.http.*

interface RestApi {

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun signIn(@Body signInRequestBody: SignInRequestBody) : Single<List<AuthResponse>>

    @POST("auth/logout")
    fun logout(): Single<Unit>

    @GET("uaa/api/account")
    fun getAccount(): Single<AccountResponse>

}