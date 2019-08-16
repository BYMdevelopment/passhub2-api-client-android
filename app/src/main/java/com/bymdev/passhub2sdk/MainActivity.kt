package com.bymdev.passhub2sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bymdev.pass2sdk.Pass2SDK
import com.bymdev.pass2sdk.core.CallbackWrapper
import com.bymdev.pass2sdk.core.PassError
import com.bymdev.pass2sdk.model.response.AuthResponse

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Pass2SDK(this.applicationContext)
            .onSignIn("dreamer1", "dreamer")
            .subscribeWith(object : CallbackWrapper<List<AuthResponse>>() {
                override fun onSuccess(result: List<AuthResponse>) {
                    Log.d(LOG_TAG, "onSuccess = $result")
                }

                override fun onError(error: PassError) {
                    Log.d(LOG_TAG, "onSuccess = $error")
                }

            })

    }

}
