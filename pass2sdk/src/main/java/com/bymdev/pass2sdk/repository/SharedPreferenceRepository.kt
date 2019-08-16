package com.bymdev.pass2sdk.repository

interface SharedPreferenceRepository {
    fun saveToken(token: String?)
    fun getToken(): String?
}