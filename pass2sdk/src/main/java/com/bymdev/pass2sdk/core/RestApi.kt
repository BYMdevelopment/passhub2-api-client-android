package com.bymdev.pass2sdk.core

import com.bymdev.pass2sdk.model.request.*
import com.bymdev.pass2sdk.model.response.AccountResponse
import com.bymdev.pass2sdk.model.response.validate.ValidationResponse
import com.bymdev.pass2sdk.model.response.ProductResponse
import com.bymdev.pass2sdk.model.response.auth.AuthResponse
import com.bymdev.pass2sdk.model.response.vendor.VendorResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface RestApi {

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun signIn(@Body signInRequestBody: SignInRequestBody) : Observable<List<AuthResponse>>

    @Headers("Content-Type: application/json")
    @POST("uaa/api/register")
    fun signUp(@Body signUpRequestBody: SignUpRequestBody) : Observable<Unit>

    @Headers("Content-Type: application/json")
    @POST("auth/logout")
    fun logout(): Single<Unit>

    @Headers("Content-Type: application/json")
    @GET("uaa/api/account")
    fun getAccount(): Observable<AccountResponse>

    @Headers("Content-Type: application/json")
    @POST("uaa/api/account/reset-password/init")
    fun resetPassword(@Body resetPasswordRequestBody: ResetPasswordRequestBody): Observable<Unit>
    @Headers("Content-Type: application/json")
    @POST("uaa/api/account/change-password")
    fun changePassword(@Body changePasswordRequestBody: ChangePasswordRequestBody): Observable<Unit>

    @Headers("Content-Type: application/json")
    @GET("/orders/api/products/available")
    fun getAvailableProducts(
        @Query("query") query: String?,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Observable<List<ProductResponse>>

    @Headers("Content-Type: application/json")
    @POST("vouchers/api/v1/vouchers/{voucherCode}/validate")
    fun validate(@Path("voucherCode") voucherCode: String,
                 @Body validationRequestBody: ValidationRequestBody): Observable<ValidationResponse>

    @Headers("Content-Type: application/json")
    @GET("/uaa/api/account/membership-rel/{id}")
    fun getVendorsList(@Path("id") id: String): Observable<List<VendorResponse>>
}