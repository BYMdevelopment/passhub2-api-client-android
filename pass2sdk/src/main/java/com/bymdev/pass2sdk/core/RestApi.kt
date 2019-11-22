package com.bymdev.pass2sdk.core

import com.bymdev.pass2sdk.model.request.*
import com.bymdev.pass2sdk.model.request.order.OrderRequestBody
import com.bymdev.pass2sdk.model.response.AccountResponse
import com.bymdev.pass2sdk.model.response.PermissionResponse
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
    @POST("uaa/api/v1/register")
    fun signUp(@Body signUpRequestBody: SignUpRequestBody) : Observable<Unit>

    @Headers("Content-Type: application/json")
    @POST("auth/logout")
    fun logout(): Single<Unit>

    @Headers("Content-Type: application/json")
    @GET("uaa/api/v1/account")
    fun getAccount(): Observable<AccountResponse>

    @Headers("Content-Type: application/json")
    @POST("uaa/api/v1/account/reset-password/init")
    fun resetPassword(@Body resetPasswordRequestBody: ResetPasswordRequestBody): Observable<Unit>

    @Headers("Content-Type: application/json")
    @POST("uaa/api/v1/account/change-password")
    fun changePassword(@Body changePasswordRequestBody: ChangePasswordRequestBody): Observable<Unit>

    @Headers("Content-Type: application/json")
    @GET("orders/api/v1/products/available")
    fun getAvailableProducts(
        @Query("query") query: String?,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Observable<List<ProductResponse>>

    @Headers("Content-Type: application/json")
    @POST("vouchers/api/v1/vouchers/{voucherCode}/validate")
    fun validate(@Path("voucherCode") voucherCode: String,
                 @Body validationRequestBody: ValidationRequestBody): Observable<ValidationResponse>

    @Deprecated("Use getAvailableVendors instead")
    @Headers("Content-Type: application/json")
    @GET("uaa/api/v1/account/membership-rel/{id}")
    fun getVendorsList(@Path("id") id: String): Observable<List<VendorResponse>>

    @Headers("Content-Type: application/json")
    @GET("uaa/api/v1/account/available-vendors")
    fun getAvailableVendors(): Observable<List<VendorResponse>>

    @Headers("Content-Type: application/json")
    @POST("orders/api/v1/orders/sync")
    fun createOrder(@Body createOrderRequestBody: OrderRequestBody): Observable<Any>

    @Headers("Content-Type: application/json")
    @GET("uaa/api/v1/permissions/current")
    fun getPermissions(@Header("$AUTH_TOKEN_HEADER_NAME") token: String?): Observable<List<PermissionResponse>>
}