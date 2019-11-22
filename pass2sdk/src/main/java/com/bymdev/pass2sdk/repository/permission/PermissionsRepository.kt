package com.bymdev.pass2sdk.repository.permission

import com.bymdev.pass2sdk.model.response.PermissionResponse
import com.bymdev.pass2sdk.room.entity.AccountEntity
import io.reactivex.Observable

interface PermissionsRepository {
    fun getPermissions(account: AccountEntity?): Observable<List<PermissionResponse>>
}