package com.bymdev.pass2sdk.core

interface VendorProvider {
    fun getCurrentVendor(): String?
}