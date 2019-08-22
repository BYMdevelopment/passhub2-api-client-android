package com.bymdev.passhub2sdk

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bymdev.pass2sdk.Pass2SDK

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = javaClass.simpleName

    private lateinit var btnTest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTest = findViewById(R.id.test_button)

        val sdk = Pass2SDK(this)
        btnTest.setOnClickListener {
        }

    }

}
