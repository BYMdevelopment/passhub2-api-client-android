package com.bymdev.pass2sdk.base

open class ResultRequest<T>(val data: T? = null,
                            val errorCode: Int? = null,
                            val message: String? = null) {

    companion object {
        fun <T> fromData( data: T ) : ResultRequest<T> {
            return ResultRequest(data)
        }

        fun <T> fromError(errorCode: Int?, message: String?) : ResultRequest<T> {
            return ResultRequest(errorCode = errorCode, message = message)
        }
    }

    fun isError() : Boolean{
        return (errorCode != null || message != null)
    }

    fun isSuccess() : Boolean {
        return data != null
    }
}