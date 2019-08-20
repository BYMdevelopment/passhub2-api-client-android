package com.bymdev.passhub2sdk

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bymdev.pass2sdk.Pass2SDK
import com.bymdev.pass2sdk.core.CallbackWrapper
import com.bymdev.pass2sdk.core.PassError
import com.bymdev.pass2sdk.model.response.ProductResponse

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = javaClass.simpleName

    private lateinit var btnTest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTest = findViewById(R.id.test_button)

        val sdk = Pass2SDK(this)
        btnTest.setOnClickListener {
            sdk.getProductList(20, 0)
                    .subscribeWith(object : CallbackWrapper<List<ProductResponse>>() {
                        override fun onSuccess(t: List<ProductResponse>) {
                            Log.d(LOG_TAG, "onSuccess products = ${t.size}")
                        }

                        override fun onError(error: PassError) {
                            Log.d(LOG_TAG, "onError error = $error")
                        }

                    })
        }

    }

}
