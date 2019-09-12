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

    override fun getCurrentAccountSingle(): Single<AccountEntity> {
        return database.accountDao().getCurrentAccountSingle()
    }

    override fun setAccountAsCurrent(account: AccountEntity): Single<Unit> {
        return getCurrentAccountSingle()
            .map {
                it.isDefault = false
                database.accountDao().update(it)
            }.map {
                account.isDefault = true
                database.accountDao().update(account)
                sharedPreferences.saveToken(account.token)
            }.applySchedulers()
    }
}