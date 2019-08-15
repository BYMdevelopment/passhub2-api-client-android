package com.bymdev.pass2sdk.core

interface AuthTokenProvider {
    fun getToken(): String?
}