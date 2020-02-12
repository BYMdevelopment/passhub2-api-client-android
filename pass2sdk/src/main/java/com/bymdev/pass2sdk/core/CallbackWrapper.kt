package com.bymdev.pass2sdk.core

import com.bymdev.pass2sdk.base.KEY_HTTP_CODE_UNAUTHORIZED
import io.reactivex.observers.DisposableObserver
import org.json.JSONObject
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

const val KEY_STATUS = "status"
const val KEY_DETAIL = "detail"
const val KEY_MESSAGE = "message"

abstract class CallbackWrapper<T> : DisposableObserver<T>(), IErrorListener {

    private val LOG_TAG = "CallbackWrapper"

    protected abstract fun onSuccess(result: T)
    protected abstract fun onError(error: PassError)

    override fun onNext(result: T) {
        onSuccess(result)
    }

    override fun onError(e: Throwable) {
        when (e) {
            is HttpException -> handleHttpError(e)
            is ConnectException -> onError(PassError(PassErrorType.CONNECTION))
            is SocketTimeoutException -> onError(PassError(PassErrorType.TIMEOUT))
            is IOException -> onError(PassError(PassErrorType.IO))
            else -> onError(PassError(PassErrorType.UNKNOWN, e.message))
        }
    }

    private fun handleHttpError(e: HttpException) {
        if(e.code() == KEY_HTTP_CODE_UNAUTHORIZED) {
            unauthorized()
        } else {
            return try {
                val errorBody = e.response()?.errorBody()?.string()
                val json = JSONObject(errorBody ?: "")
                val status = json.getInt(KEY_STATUS)
                val detail = json.getString(KEY_MESSAGE)
                onError(PassError(PassErrorType.HTTP, status.toString(), detail))
            } catch (exception : Exception) {
                onError(PassError(PassErrorType.HTTP, e.code().toString(), e.message()))
            }
        }
    }

    override fun onComplete() {}

    override fun unauthorized() {}
}