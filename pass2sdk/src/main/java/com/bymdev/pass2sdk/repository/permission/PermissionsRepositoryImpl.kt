package com.bymdev.pass2sdk.repository.permission

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.model.response.PermissionResponse
import io.reactivex.Observable

class PermissionsRepositoryImpl(private val context: Context) : BaseNetworkRepository(context), PermissionsRepository {

    override fun getCurrentPermissions(): Observable<List<PermissionResponse>> {
        return restClient.getCurrentPermissions().applySchedulers()
    }

}