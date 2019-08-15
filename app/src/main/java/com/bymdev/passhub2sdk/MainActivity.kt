package com.bymdev.passhub2sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bymdev.pass2sdk.Pass2SDK
import com.bymdev.pass2sdk.base.ResultRequest
import com.bymdev.pass2sdk.model.response.AuthResponse

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Pass2SDK(this.applicationContext).onSignIn("dreamer", "dreamer")
            .doOnSuccess {
                if(it.isSuccess() && it.data != null) {
                    onSignInSuccess(it.data as List<AuthResponse>)
                } else {
                    onSignInError(it)
                }
            }.subscribe()
    }

    private fun onSignInSuccess(response: List<AuthResponse>) {
        Log.d(LOG_TAG, "onSignInSuccess() response = $response")
    }

    private fun onSignInError(result: ResultRequest<List<AuthResponse>>) {
        Log.d(LOG_TAG, "onSignInError() errorCode = ${result.errorCode} message = ${result.message}")
    }

}
