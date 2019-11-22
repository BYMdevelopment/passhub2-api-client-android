package com.bymdev.pass2sdk.repository.permission

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.core.BEARER
import com.bymdev.pass2sdk.model.response.PermissionResponse
import com.bymdev.pass2sdk.room.entity.AccountEntity
import io.reactivex.Observable

class PermissionsRepositoryImpl(private val context: Context) : BaseNetworkRepository(context), PermissionsRepository {

    override fun getPermissions(account: AccountEntity?): Observable<List<PermissionResponse>> {
        var token: String? = null
        if(account?.token != null) {
            token = "$BEARER ${account.token}"
        }
        return restClient
            .getPermissions(token)
            .applySchedulers()
    }

}