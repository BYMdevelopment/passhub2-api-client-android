package com.bymdev.pass2sdk.repository.db

import com.bymdev.pass2sdk.room.entity.AccountEntity
import io.reactivex.Single

interface DBRepository {
    fun getAccounts(): Single<List<AccountEntity>>
    fun getCurrentAccount(): Single<AccountEntity>
    fun setAccountAsCurrent(account: AccountEntity): Single<Int>
}