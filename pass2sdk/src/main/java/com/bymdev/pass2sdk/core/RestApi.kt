package com.bymdev.pass2sdk.core

import com.bymdev.pass2sdk.model.request.SignInRequestBody
import com.bymdev.pass2sdk.model.response.AccountResponse
import com.bymdev.pass2sdk.model.response.AuthResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun signIn(@Body signInRequestBody: SignInRequestBody) : Observable<List<AuthResponse>>

    @POST("auth/logout")
    fun logout(): Observable<Unit>

    @GET("uaa/api/account")
    fun getAccount(): Observable<AccountResponse>

}