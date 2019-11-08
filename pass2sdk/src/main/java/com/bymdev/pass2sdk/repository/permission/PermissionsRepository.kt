package com.bymdev.pass2sdk.repository.permission

import com.bymdev.pass2sdk.model.response.PermissionResponse
import io.reactivex.Observable

interface PermissionsRepository {
    fun getCurrentPermissions(): Observable<List<PermissionResponse>>
}