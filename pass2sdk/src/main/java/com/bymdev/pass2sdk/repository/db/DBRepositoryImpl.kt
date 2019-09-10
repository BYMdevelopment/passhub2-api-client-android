package com.bymdev.pass2sdk.repository.db

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.room.entity.AccountEntity
import io.reactivex.Observable
import io.reactivex.Single

class DBRepositoryImpl(context: Context) : BaseNetworkRepository(context),
    DBRepository {

    override fun getAccounts(): Single<List<AccountEntity>> {
        return database.accountDao().getAccounts().applySchedulers()
    }

    override fun getCurrentAccount(): Observable<AccountEntity> {
        return database.accountDao().getCurrentAccount()
    }

    override fun setAccountAsCurrent(account: AccountEntity): Observable<Unit> {
        return getCurrentAccount()
            .map {
                it.isDefault = false
                it
            }
            .map { database.accountDao().update(it) }
            .map {
                account.isDefault = true
                database.accountDao().update(account)
            }.map { sharedPreferences.saveToken(account.token) }
    }

}