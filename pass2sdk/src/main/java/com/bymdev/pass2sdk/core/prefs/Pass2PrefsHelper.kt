package com.bymdev.pass2sdk.core.prefs

import android.content.Context
import android.content.SharedPreferences
import com.bymdev.pass2sdk.R
import com.bymdev.pass2sdk.model.response.auth.Vendor
import com.google.gson.GsonBuilder

class Pass2PrefsHelper(private val context: Context) {

    private val KEY_TOKEN = "${javaClass.`package`}.TOKEN"
    private val KEY_REFRESH_TOKEN = "${javaClass.`package`}.REFRESH_TOKEN"
    private val KEY_VENDOR = "${javaClass.`package`}.VENDOR"

    fun putToken(token: String?, refreshToken: String?) {
        putStringPref(KEY_TOKEN, token)
        putStringPref(KEY_REFRESH_TOKEN, refreshToken)
    }

    fun getToken() = getStringPref(KEY_TOKEN)

    fun getRefreshToken() = getStringPref(KEY_REFRESH_TOKEN)

    fun putCurrentVendor(vendor: Vendor) {
        putObject(KEY_VENDOR, vendor)
    }

    fun getCurrentVendor() = getObject(KEY_VENDOR, Vendor::class.java)

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            context.resources.getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )
    }

    private fun <T> getObject(key: String, clazz: Class<T>): T? {
        val sharedPref = getSharedPreferences(context)
        return getObjectFromPrefs(sharedPref, key, clazz)
    }

    private fun putObject(key: String, `object`: Any) {
        val sharedPref = getSharedPreferences(context)
        val editor = sharedPref.edit()
        putObjectToPrefs(editor, key, `object`)
        editor.commit()
    }

    private fun getStringPref(key: String): String? {
        val sharedPref = getSharedPreferences(context)
        return sharedPref.getString(key, null)
    }

    private fun putStringPref(key: String, value: String?) {
        val sharedPref = getSharedPreferences(context)
        val editor = sharedPref.edit()
        editor.putString(key, value)
        editor.commit()
    }

    private fun getIntPref(key: String, defValue: Int): Int {
        val sharedPref = getSharedPreferences(context)
        return sharedPref.getInt(key, defValue)
    }

    private fun putIntPref(key: String, value: Int) {
        val sharedPref = getSharedPreferences(context)
        val editor = sharedPref.edit()
        editor.putInt(key, value)
        editor.commit()
    }

    private fun getBooleanPref(key: String, defValue: Boolean): Boolean {
        val sharedPref = getSharedPreferences(context)
        return sharedPref.getBoolean(key, defValue)
    }

    private fun getBooleanPref(key: String): Boolean {
        val sharedPref = getSharedPreferences(context)
        return sharedPref.getBoolean(key, false)
    }

    private fun putBooleanPref(key: String, value: Boolean?) {
        val sharedPref = getSharedPreferences(context)
        val editor = sharedPref.edit()
        editor.putBoolean(key, value!!)
        editor.commit()
    }

    private fun getLongPref(key: String): Long {
        val sharedPref = getSharedPreferences(context)
        return sharedPref.getLong(key, 0)
    }

    private fun putLongPref(key: String, value: Long) {
        val sharedPref = getSharedPreferences(context)
        val editor = sharedPref.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    private fun <T> getObjectFromPrefs(preferences: SharedPreferences, key: String, clazz: Class<T>): T? {

        val string = preferences.getString(key, null)
        return if (string == null) {
            null
        } else {
            try {
                val gson = GsonBuilder().create()
                gson.fromJson(string, clazz)
            } catch (e: Exception) {
                throw IllegalArgumentException("Object stored with key $key is instanceof other class")
            }

        }
    }

    private fun putObjectToPrefs(editor: SharedPreferences.Editor, key: String, `object`: Any?) {
        if (key == "") {
            throw IllegalArgumentException("key is empty or null")
        }
        var value: String? = null
        if (`object` != null) {
            val gson = GsonBuilder().create()
            value = gson.toJson(`object`)
        }
        editor.putString(key, value)
    }
}