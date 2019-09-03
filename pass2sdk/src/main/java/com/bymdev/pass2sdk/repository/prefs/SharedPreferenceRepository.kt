package com.bymdev.pass2sdk.repository.prefs

interface SharedPreferenceRepository {
    fun saveToken(token: String?)
    fun getToken(): String?
}