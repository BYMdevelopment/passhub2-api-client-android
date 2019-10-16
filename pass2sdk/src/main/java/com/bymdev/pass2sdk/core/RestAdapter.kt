package com.bymdev.pass2sdk.core

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestAdapter(context: Context) : IRestAdapter {

    private val authTokenProvider = AuthTokenProviderImpl(context)
    private val vendorProvider = VendorProviderImpl(context)

    override fun <T> createApi(clazz: Class<T>) = setUpAdapter(clazz)

    private fun <T> setUpAdapter(clazz: Class<T>): T {

        val client  = OkHttpClient.Builder()
            .addInterceptor(Pass2ServiceInterceptor(authTokenProvider, vendorProvider))
            .addNetworkInterceptor(StethoInterceptor())
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl("http://66.70.204.185:8000/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(clazz)
    }

    private class Pass2ServiceInterceptor(private val authTokenProvider: AuthTokenProvider,
                                          private val vendorProvider: VendorProvider) : Interceptor {
        private val AUTH_TOKEN_HEADER_NAME = "Authorization"
        private val BEARER = "Bearer"
        private val HEADER_VENDOR = "x-passhub-v2-vendor"

        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()

            val authToken = authTokenProvider.getToken()
            val vendorCode = vendorProvider.getCurrentVendor()
            if (authToken != null && authToken.isNotEmpty()) {
                // Request customization: add request headers
                val original = request
                val requestBuilder = original.newBuilder()
                        .addHeader(AUTH_TOKEN_HEADER_NAME, "$BEARER $authToken")
                    .method(original.method(), original.body())
                if(vendorCode != null) {
                    requestBuilder.addHeader(HEADER_VENDOR, vendorCode)
                }
                request = requestBuilder.build()
            }

            return chain.proceed(request)
        }

    }

}