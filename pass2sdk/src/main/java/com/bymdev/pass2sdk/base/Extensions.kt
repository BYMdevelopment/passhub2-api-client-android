package com.bymdev.pass2sdk.base

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import com.bymdev.pass2sdk.core.RefreshTokenHandler
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.applySchedulers(
    subscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread()
): Observable<T> =
    this.subscribeOn(subscribeOn).observeOn(observeOn)

fun <T> Single<T>.applySchedulers(
    subscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread()
): Single<T> =
    this.subscribeOn(subscribeOn).observeOn(observeOn)

fun <T> lazyUnsynchronized(initializer: () -> T): Lazy<T> =
        lazy(LazyThreadSafetyMode.NONE, initializer)

fun <ViewT : View> Activity.bindView(@IdRes idRes: Int): Lazy<ViewT> {
    return lazyUnsynchronized {
        findViewById<ViewT>(idRes)
    }
}

fun <T> Observable<T>.addTokenHandler(handler: RefreshTokenHandler<Observable<Throwable>>): Observable<T> = this.retryWhen(handler).applySchedulers()