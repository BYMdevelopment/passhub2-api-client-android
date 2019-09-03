package com.bymdev.pass2sdk.repository.db

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.applySchedulers
import com.bymdev.pass2sdk.room.entity.AccountEntity
import io.reactivex.Single

class DBRepositoryImpl(context: Context) : BaseNetworkRepository(context),
    DBRepository {

    override fun getAccounts(): Single<List<AccountEntity>> {
        return database.accountDao().getAccounts().applySchedulers()
    }

    override fun getCurrentAccount(): AccountEntity {
        return database.accountDao().getCurrentAccount()
    }

    override fun updateSelectedAccount(account: AccountEntity): Single<Int> {
        return database.accountDao().update(account)
            .applySchedulers()
            .doOnSuccess { sharedPreferences.saveToken(account.token) }
    }

}