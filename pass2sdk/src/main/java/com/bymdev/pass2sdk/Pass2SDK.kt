package com.bymdev.pass2sdk

import android.content.Context
import com.bymdev.pass2sdk.base.KEY_DEFAULT_PRODUCT_OFFSET
import com.bymdev.pass2sdk.base.KEY_DEFAULT_PRODUCT_PAGE
import com.bymdev.pass2sdk.repository.AuthRepositoryImpl
import com.bymdev.pass2sdk.repository.VoucherRepositoryImpl
import com.bymdev.pass2sdk.usecase.VoucherUseCase
import com.bymdev.pass2sdk.repository.ProductRepositoryImpl
import com.bymdev.pass2sdk.usecase.AccountUseCase
import com.bymdev.pass2sdk.usecase.AuthUseCase
import com.bymdev.pass2sdk.usecase.PrefsUseCase
import com.bymdev.pass2sdk.usecase.ProductUseCase

class Pass2SDK(private val context: Context) {

    private val accountUseCase = AccountUseCase(context)
    private var prefsUseCase: PrefsUseCase = PrefsUseCase(context)
    private val authUseCase = AuthUseCase(AuthRepositoryImpl(context, prefsUseCase))
    private val productUseCase = ProductUseCase(ProductRepositoryImpl(context))
    private val voucherUseCase = VoucherUseCase(VoucherRepositoryImpl(context))

//    Auth resources
    fun signIn(login: String, password: String) = authUseCase.signIn(login, password)
    fun signUp(fName: String, lName: String, email: String, password: String, login: String)
            = authUseCase.signUp(fName, lName, email, password, login)
    fun logout() = authUseCase.logout()
    fun resetPassword(email: String) = authUseCase.resetPassword(email)

//    Products resources
    fun getProductList(offset: Int = KEY_DEFAULT_PRODUCT_OFFSET,
                       page: Int = KEY_DEFAULT_PRODUCT_PAGE,
                       query: String? = null) = productUseCase.getProductList(offset, page, query)

//    Validation resources
    fun validate(voucherCode: String) = voucherUseCase.validate(voucherCode)


}