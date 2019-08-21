package com.bymdev.pass2sdk.core

import com.bymdev.pass2sdk.model.request.ResetPasswordRequestBody
import com.bymdev.pass2sdk.model.request.SignInRequestBody
import com.bymdev.pass2sdk.model.request.SignUpRequestBody
import com.bymdev.pass2sdk.model.request.ValidationRequestBody
import com.bymdev.pass2sdk.model.response.AccountResponse
import com.bymdev.pass2sdk.model.response.AuthResponse
import com.bymdev.pass2sdk.model.response.validate.ValidationResponse
import com.bymdev.pass2sdk.model.response.ProductResponse
import io.reactivex.Observable
import retrofit2.http.*

interface RestApi {

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun signIn(@Body signInRequestBody: SignInRequestBody) : Observable<List<AuthResponse>>

    @Headers("Content-Type: application/json")
    @POST("uaa/api/register")
    fun signUp(@Body signUpRequestBody: SignUpRequestBody) : Observable<Unit>

    @POST("auth/logout")
    fun logout(): Observable<Unit>

    @GET("uaa/api/account")
    fun getAccount(): Observable<AccountResponse>

    @Headers("Content-Type: application/json")
    @POST("uaa/api/account/reset-password/init")
    fun resetPassword(@Body resetPasswordRequestBody: ResetPasswordRequestBody): Observable<Unit>

    @Headers("Content-Type: application/json")
    @GET("products/api/v1/_search/products/all")
    fun getProducts(@Query("offset") offset: Int,
                    @Query("page") page: Int,
                    @Query("query") query: String?): Observable<List<ProductResponse>>

    @Headers("Content-Type: application/json")
    @POST("vouchers/api/v1/vouchers/{voucherCode}/validate")
    fun validate(@Path("voucherCode") voucherCode: String,
                 @Body validationRequestBody: ValidationRequestBody): Observable<ValidationResponse>

}