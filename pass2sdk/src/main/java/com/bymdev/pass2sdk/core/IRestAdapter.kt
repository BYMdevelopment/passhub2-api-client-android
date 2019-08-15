package com.bymdev.pass2sdk.core

interface IRestAdapter {

    fun <T> createApi(clazz: Class<T>): T

}