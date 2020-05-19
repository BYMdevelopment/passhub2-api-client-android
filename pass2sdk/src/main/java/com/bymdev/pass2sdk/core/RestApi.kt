package com.bymdev.pass2sdk.core

import com.bymdev.pass2sdk.base.AUTH_TOKEN_HEADER_NAME
import com.bymdev.pass2sdk.base.REFRESH_TOKEN_HEADER_NAME
import com.bymdev.pass2sdk.model.CategoryResponse
import com.bymdev.pass2sdk.model.request.*
import com.bymdev.pass2sdk.model.request.order.OrderRequestBody
import com.bymdev.pass2sdk.model.response.*
import com.bymdev.pass2sdk.model.response.validate.ValidationResponse
import com.bymdev.pass2sdk.model.response.auth.AuthResponse
import com.bymdev.pass2sdk.model.response.convert.ConvertResponse
import com.bymdev.pass2sdk.model.response.order.OrderCreateResponse
import com.bymdev.pass2sdk.model.response.vendor.VendorResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface RestApi {

    @Headers("Content-Type: application/json")
    @POST(" /auth/refresh-token")
    fun refreshToken(@Header("$REFRESH_TOKEN_HEADER_NAME") token: String) : Observable<RefreshTokenResponse>

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
        @Query("size") size: Int,
        @Query("sort") sort: String?
    ): Observable<List<ProductResponse>>

    @Headers("Content-Type: application/json")
    @POST("vouchers/api/v1/vouchers/{voucherCode}/validate")
    fun validate(@Path("voucherCode") voucherCode: String,
                 @Body validationRequestBody: ValidationRequestBody): Observable<ValidationResponse>

    @Headers("Content-Type: application/json")
    @POST("vouchers/api/v1/vouchers/convert")
    fun convert(@Query("code") code: String,
                @Query("oldAlias") oldAlias: String,
                @Query("newAlias") newAlias: String): Observable<ConvertResponse>

    @Deprecated("Use getAvailableVendors instead")
    @Headers("Content-Type: application/json")
    @GET("uaa/api/v1/account/membership-rel/{id}")
    fun getVendorsList(@Path("id") id: String): Observable<List<VendorResponse>>

    @Headers("Content-Type: application/json")
    @GET("uaa/api/v1/account/available-vendors")
    fun getAvailableVendors(): Observable<List<VendorResponse>>

    @Headers("Content-Type: application/json")
    @POST("orders/api/v1/orders/sync")
    fun createOrder(@Body createOrderRequestBody: OrderRequestBody): Observable<OrderCreateResponse>

    @Headers("Content-Type: application/json")
    @POST("orders/api/v1/orders")
    fun createOrderAsync(@Body createOrderRequestBody: OrderRequestBody): Observable<OrderCreateResponse>

    @Headers("Content-Type: application/json")
    @GET("orders/api/v1/orders/{id}")
    fun getOrderById(@Path("id") id: Int): Observable<OrderCreateResponse>

    @Headers("Content-Type: application/json")
    @GET("uaa/api/v1/permissions/current")
    fun getPermissions(@Header("$AUTH_TOKEN_HEADER_NAME") token: String?,
                       @Query("msCode") msCode: String?): Observable<List<PermissionResponse>>

    @Headers("Content-Type: application/json")
    @GET("products/api/v1/categories")
    fun getCategories(@Query("page") page: Int,
                      @Query("size") size: Int,
                      @Query("sort") sort: String): Observable<List<CategoryResponse>>

    @Headers("Content-Type: application/json")
    @GET("uaa/api/v1/vendors/configs")
    fun checkVendorConfiguration(): Observable<List<VendorConfigurationResponse>>

    @Headers("Content-Type: application/json")
    @GET("orders/api/v1/payments/stripe/terminal/connection-token")
    fun fetchConnectionToken(): Observable<StripeConnectionTokenResponse>

    @Headers("Content-Type: application/json")
    @POST("orders/api/v1/payments/stripe/terminal/payment-capture")
    fun confirmPayment(@Body body: ConfirmPaymentRequestBody): Observable<Unit>
}