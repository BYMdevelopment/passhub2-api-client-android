package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.repository.permission.PermissionsRepository
import com.bymdev.pass2sdk.room.entity.AccountEntity

class PermissionsUseCase(private val repository: PermissionsRepository) {

    fun getPermissions(account: AccountEntity?, msCode: String?) = repository.getPermissions(account, msCode)
}