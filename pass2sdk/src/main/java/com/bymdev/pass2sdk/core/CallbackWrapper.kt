package com.bymdev.pass2sdk.core

import io.reactivex.observers.DisposableObserver
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException

data class PassError(var type: PassErrorType,
                     var code: String? = null,
                     var message: String? = null)

enum class PassErrorType {
    HTTP, CONNECTION, TIMEOUT, IO, UNKNOWN
}

abstract class CallbackWrapper<T> : DisposableObserver<T>() {

    private val LOG_TAG = "CallbackWrapper"

    protected abstract fun onSuccess(result: T)
    protected abstract fun onError(error: PassError)

    override fun onNext(result: T) {
        onSuccess(result)
    }

    override fun onError(e: Throwable) {
        when (e) {
            is HttpException -> onError(getHttpError(e))
            is ConnectException -> onError(PassError(PassErrorType.CONNECTION))
            is SocketTimeoutException -> onError(PassError(PassErrorType.TIMEOUT))
            is IOException -> onError(PassError(PassErrorType.IO))
            else -> onError(PassError(PassErrorType.UNKNOWN))
        }
    }

    private fun getHttpError(e: HttpException) : PassError {
        return PassError(PassErrorType.HTTP, e.code().toString(), e.message())
    }

    override fun onComplete() {

    }
}