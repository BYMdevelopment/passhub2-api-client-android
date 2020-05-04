package com.bymdev.pass2sdk.core

import com.bymdev.pass2sdk.base.KEY_HTTP_CODE_UNAUTHORIZED
import com.bymdev.pass2sdk.base.RETRY_TIME
import com.bymdev.pass2sdk.model.response.RefreshTokenResponse
import com.bymdev.pass2sdk.repository.prefs.SharedPreferenceRepository
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import retrofit2.HttpException
import retrofit2.Response

class RefreshTokenHandler<T: Observable<Throwable>>(private val restClient: RestApi,
                                                    private val sharedPreferenceRepository: SharedPreferenceRepository) : Function<T, ObservableSource<Any>> {

    override fun apply(originalObservable: T): ObservableSource<Any> {
        return originalObservable.zipWith(
            Observable.range(1, RETRY_TIME),
            object : BiFunction<Throwable, Int, Pair<Throwable, Boolean>> {
                override fun apply(t1: Throwable, t2: Int): Pair<Throwable, Boolean> {
                    if (t2 < RETRY_TIME && t1 is HttpException && t1.code() == KEY_HTTP_CODE_UNAUTHORIZED) {
                        return Pair(t1, true)
                    }
                    return Pair(t1, false)
                }
            }).flatMap { t ->
            if (t.second) {
                // refresh access_token with refresh_token
                Observable.create<RefreshTokenResponse> {
                    restClient.refreshToken(sharedPreferenceRepository.getRefreshToken())
                        .subscribeWith(object : CallbackWrapper<RefreshTokenResponse>() {
                            override fun onSuccess(result: RefreshTokenResponse) {
                                sharedPreferenceRepository.saveToken(result.accessToken, result.refreshToken)
                                it.onNext(result)
                                it.onComplete()
                            }

                            override fun onError(error: PassError) {
                                val builder = Response.error<Any>(KEY_HTTP_CODE_UNAUTHORIZED, null)
                                it.onError(HttpException(builder))
                            }
                        })
                }
            } else {
                Observable.error<Any>(t.first)
            }
        }
    }
}