package com.bymdev.pass2sdk.room.dao

import androidx.room.*
import com.bymdev.pass2sdk.room.entity.AccountEntity
import io.reactivex.Single

@Dao
abstract class AccountDao {

    @Query("SELECT * FROM account")
    abstract fun getAccounts(): Single<List<AccountEntity>>

    @Query("SELECT * FROM account WHERE isDefault = 1")
    abstract fun getCurrentAccount(): AccountEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(account: AccountEntity)

    @Update
    abstract fun update(account: AccountEntity): Single<Int>

    @Query("DELETE FROM account")
    abstract fun delete()
}