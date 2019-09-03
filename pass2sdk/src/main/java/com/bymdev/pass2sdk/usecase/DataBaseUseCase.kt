package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.repository.db.DBRepository
import com.bymdev.pass2sdk.room.entity.AccountEntity

class DataBaseUseCase(private val dbRepository: DBRepository) {

    fun getAccounts() = dbRepository.getAccounts()

    fun getCurrentAccount() = dbRepository.getCurrentAccount()

    fun setAccountAsCurrent(account: AccountEntity) = dbRepository.setAccountAsCurrent(account)

}