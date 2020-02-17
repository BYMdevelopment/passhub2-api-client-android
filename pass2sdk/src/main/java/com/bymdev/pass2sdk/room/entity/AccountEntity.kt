package com.bymdev.pass2sdk.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account")
data class AccountEntity(
    @PrimaryKey
    var memberId: String,
    var token: String?,
    val refresh_token: String?,
    var name: String?,
    var isDefault: Boolean = false
) {
    constructor(memberId: String) : this(memberId, "", "", "")
}