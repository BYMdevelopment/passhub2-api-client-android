package com.bymdev.pass2sdk.usecase

import com.bymdev.pass2sdk.repository.stripe.StripeRepository

class StripeUseCase(private val stripeRepository: StripeRepository) {

    fun fetchStripeConnectionToken() = stripeRepository.fetchStripeConnectionToken()

}