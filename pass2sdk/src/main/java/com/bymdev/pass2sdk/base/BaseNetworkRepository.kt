package com.bymdev.pass2sdk.base

import android.content.Context
import com.bymdev.pass2sdk.core.RestClient

abstract class BaseNetworkRepository(context: Context) {

    val restClient = RestClient.getInstance(context).getService()
}