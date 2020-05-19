package com.bymdev.pass2sdk

import android.content.Context
import com.bymdev.pass2sdk.base.DEFAULT_OFFSET
import com.bymdev.pass2sdk.base.DEFAULT_PAGE_NUMBER
import com.bymdev.pass2sdk.enums.ProductType
import com.bymdev.pass2sdk.enums.SortBy
import com.bymdev.pass2sdk.enums.SortOrder
import com.bymdev.pass2sdk.model.request.ValidationRequestBody
import com.bymdev.pass2sdk.model.request.order.OrderRequestBody
import com.bymdev.pass2sdk.model.response.ProductResponse
import com.bymdev.pass2sdk.model.response.auth.Vendor
import com.bymdev.pass2sdk.repository.auth.AuthRepositoryImpl
import com.bymdev.pass2sdk.repository.category.CategoryRepositoryImpl
import com.bymdev.pass2sdk.repository.db.DBRepositoryImpl
import com.bymdev.pass2sdk.repository.permission.PermissionsRepositoryImpl
import com.bymdev.pass2sdk.repository.product.ProductRepositoryImpl
import com.bymdev.pass2sdk.repository.stripe.StripeRepositoryImpl
import com.bymdev.pass2sdk.repository.vendor.VendorRepositoryImpl
import com.bymdev.pass2sdk.repository.voucher.VoucherRepositoryImpl
import com.bymdev.pass2sdk.room.entity.AccountEntity
import com.bymdev.pass2sdk.usecase.*


class Pass2SDK(private val context: Context) {

    private val accountUseCase = AccountUseCase(context)
    private var prefsUseCase: PrefsUseCase = PrefsUseCase(context)
    private val authUseCase = AuthUseCase(AuthRepositoryImpl(context, prefsUseCase))
    private val productUseCase = ProductUseCase(ProductRepositoryImpl(context))
    private val voucherUseCase = VoucherUseCase(VoucherRepositoryImpl(context))
    private val dbUseCase = DataBaseUseCase(DBRepositoryImpl(context))
    private val vendorUseCase = VendorUseCase(VendorRepositoryImpl(context))
    private val permissionsUseCase = PermissionsUseCase(PermissionsRepositoryImpl(context))
    private val categoryUseCase = CategoryUseCase(CategoryRepositoryImpl(context))
    private val stripeUseCase = StripeUseCase(StripeRepositoryImpl(context))

    fun signIn(login: String, password: String) = authUseCase.signIn(login, password)
    fun signUp(fName: String, lName: String, login: String, email: String, password: String)
            = authUseCase.signUp(fName, lName, login, email, password)
    fun logout() = authUseCase.logout()
    fun resetPassword(email: String) = authUseCase.resetPassword(email)
    fun changePassword(password: String) = authUseCase.changePassword(password)

    /**
     * Returns a list of products that available for validation
     * or for sale.
     * To get a list of products available for sale, call this method
     * without vendorCode
     * To get a list of products available for validation, call this method
     * and pass the vendorCode
     * <p>
     * This method returns Observable<List<ProductResponse>>
     *
     * @param  vendorCode code of a vendor
     * @param  productType type of the product
     * @return  list of products Observable<List<ProductResponse>>
     * @see     ProductResponse
     * @see     ProductType
     */
    fun getAvailableProducts(vendorCode: String? = null,
                             productType: ProductType? = null,
                             page: Int = DEFAULT_PAGE_NUMBER,
                             offset: Int = DEFAULT_OFFSET,
                             query: String? = null,
                             sortBy: SortBy?,
                             sortOrder: SortOrder?,
                             categories: List<String>?,
                             withoutCategory: Boolean? = false)
            = productUseCase.getAvailableProducts(vendorCode, productType, page, offset, query, sortBy, sortOrder, categories, withoutCategory)

    /**
     * Use this method for validate.
     * vouchers. For validation
     * you need to pass voucher code
     * in request body model.
     * <p>
     * This method returns {@link ValidationResponse}
     *
     * @return  Result of validation
     */
    fun validate(requestBody: ValidationRequestBody) = voucherUseCase.validate(requestBody)

    /**
     * Use this method to convert
     * one voucher into another. For converting
     * you need to pass "code", "oldAlias" and "newAlias".
     * <p>
     * This method returns {@link ConvertResponse}
     *
     * @return  Result of converting vouchers
     */
    fun voucherConvert(code: String, oldAlias: String, newAlias: String) = voucherUseCase.convert(code, oldAlias, newAlias)

    /**
     * Returns access token if exists.
     * To check if the user already logged in, call this method
     * if the token is not empty, user logged in
     * <p>
     * This method returns {@link String}
     *
     * @return  Access Token String
     */
    fun getToken() = authUseCase.getToken()

    fun getVendorList() = vendorUseCase.getVendorList()

    fun getCurrentVendor() = prefsUseCase.getCurrentVendor()

    fun setCurrentVendor(code: String, name: String) = prefsUseCase.putCurrentVendor(Vendor(code, name))

    /**
     * Use this method to get
     * list of user profiles.
     * <p>
     * This method returns {@link List<AccountEntity>}
     *
     * @return  List profiles
     */
    fun getAccounts() = dbUseCase.getAccounts()

    /**
     * Use this method to get
     * current user profile.
     * <p>
     * This method returns {@link AccountEntity}
     *
     * @return  Current profile
     */
    fun getCurrentAccount() = dbUseCase.getCurrentAccount()

    /**
     * Use this method for set up
     * new profile as current.
     * <p>
     * This method returns {@link Observable<Unit>}
     *
     * @return  Unit
     */
    fun setAccountAsCurrent(account: AccountEntity) = dbUseCase.setAccountAsCurrent(account)

    /**
     * type = POST
     * Use this method to create order sync,
     * <p>
     * This method returns {@link OrderCreateResponse}
     *
     * @return  created order
     */
    fun createOrder(requestBody: OrderRequestBody) = productUseCase.createOrder(requestBody)

    /**
     * type = POST
     * Use this method to create order async,
     * <p>
     * This method returns {@link OrderCreateResponse}
     *
     * @return  created order
     */
    fun createOrderAsync(requestBody: OrderRequestBody) = productUseCase.createOrderAsync(requestBody)

    /**
     * type = GET
     * Use this method to create order by id,
     * <p>
     * This method returns {@link OrderCreateResponse}
     *
     * @return  Order by order id
     */
    fun getOrderById(id: Int) = productUseCase.getOrderById(id)

    /**
     * type = POST
     * Use this method to confirm stripe terminal payment,
     * <p>
     */
    fun confirmPayment(orderId: Int, paymentId: String) = productUseCase.confirmPayment(orderId, paymentId)

    /**
     * type = GET
     * Use this method to get
     * list of current user permissions.
     * Pass AccountEntity to get
     * list of permissions for another account
     * <p>
     * Pass msCode to get list of permissions
     * with specific MSCode
     * <p>
     * This method returns {@link List<PermissionResponse>}
     *
     * @return  List of permissions
     */
    fun getPermissions(account: AccountEntity? = null, msCode: String? = null) = permissionsUseCase.getPermissions(account, msCode)

    /**
     * type = GET
     * Use this method to get
     * list of categories,
     * <p>
     * This method returns {@link List<CategoryResponse>}
     *
     * @return  List of categories
     */
    fun getCategories(page: Int = DEFAULT_PAGE_NUMBER,
                      size: Int = DEFAULT_OFFSET,
                      sortOrder: String = SortOrder.ASC.type) = categoryUseCase.getCategories(page, size, sortOrder)

    /**
     * type = GET
     * Use this method to check
     * vendor configuration for payments,
     * <p>
     * This method returns {@link List<VendorConfigurationResponse>}
     *
     * @return  List of configurations
     */
    fun checkVendorConfiguration() = vendorUseCase.checkVendorConfiguration()

    /**
     * type = GET
     * Use this method to fetch
     * connection token for stripe terminal,
     * <p>
     * This method returns {@link StripeConnectionTokenResponse}
     *
     * @return  Stripe connection token
     */
    fun fetchStripeConnectionToken() = stripeUseCase.fetchStripeConnectionToken()


}