package com.bymdev.pass2sdk.repository.stripe

import android.content.Context
import com.bymdev.pass2sdk.base.BaseNetworkRepository
import com.bymdev.pass2sdk.base.addTokenHandler
import com.bymdev.pass2sdk.model.response.StripeConnectionTokenResponse
import io.reactivex.Observable

class StripeRepositoryImpl(context: Context) : BaseNetworkRepository(context), StripeRepository {

    override fun fetchStripeConnectionToken(): Observable<StripeConnectionTokenResponse> {
        return restClient.fetchConnectionToken().addTokenHandler(refreshTokenHandler)
    }

}