package com.bymdev.passhub2sdk

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bymdev.pass2sdk.Pass2SDK

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = javaClass.simpleName

    private lateinit var btnLogin: Button
    private lateinit var btnRequest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.loginBtn)
        btnRequest = findViewById(R.id.requestBtn)

        val sdk = Pass2SDK(this)
        btnLogin.setOnClickListener {}
        btnRequest.setOnClickListener {}
    }
}
