package com.bymdev.pass2sdk.repository.stripe

import com.bymdev.pass2sdk.model.response.StripeConnectionTokenResponse
import io.reactivex.Observable

interface StripeRepository {
    fun fetchStripeConnectionToken(): Observable<StripeConnectionTokenResponse>
}