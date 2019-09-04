package com.bymdev.pass2sdk.repository.db

import com.bymdev.pass2sdk.room.entity.AccountEntity
import io.reactivex.Observable
import io.reactivex.Single

interface DBRepository {
    fun getAccounts(): Single<List<AccountEntity>>
    fun getCurrentAccount(): Observable<AccountEntity>
    fun setAccountAsCurrent(account: AccountEntity): Single<Int>
}