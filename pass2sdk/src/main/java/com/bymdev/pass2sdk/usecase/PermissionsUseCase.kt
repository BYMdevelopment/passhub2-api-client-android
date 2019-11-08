package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.repository.permission.PermissionsRepository

class PermissionsUseCase(private val repository: PermissionsRepository) {

    fun getCurrentPermissions() = repository.getCurrentPermissions()
}