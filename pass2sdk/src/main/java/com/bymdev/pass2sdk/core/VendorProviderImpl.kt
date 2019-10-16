package com.bymdev.pass2sdk.core

import android.content.Context
import com.bymdev.pass2sdk.core.prefs.Pass2PrefsHelper

class VendorProviderImpl(private val context: Context) : VendorProvider {

    override fun getCurrentVendor() = Pass2PrefsHelper(context).getCurrentVendor()?.code

}