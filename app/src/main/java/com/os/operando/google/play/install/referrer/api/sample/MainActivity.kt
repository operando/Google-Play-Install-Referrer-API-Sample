package com.os.operando.google.play.install.referrer.api.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.android.installreferrer.api.InstallReferrerClient
import com.android.installreferrer.api.InstallReferrerClient.InstallReferrerResponse
import com.android.installreferrer.api.InstallReferrerStateListener


class MainActivity : AppCompatActivity() {

    private lateinit var referrerClient: InstallReferrerClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        referrerClient = InstallReferrerClient.newBuilder(this).build()
        referrerClient.startConnection(object : InstallReferrerStateListener {
            override fun onInstallReferrerSetupFinished(responseCode: Int) {
                when (responseCode) {
                    InstallReferrerResponse.OK -> {
                        val response = referrerClient.installReferrer
                        Log.d("testtest", response.installReferrer)
                        Log.d("testtest", response.referrerClickTimestampSeconds.toString())
                        Log.d("testtest", response.installBeginTimestampSeconds.toString())
                        referrerClient.endConnection()
                    }
                    InstallReferrerResponse.FEATURE_NOT_SUPPORTED -> {
                    }
                    InstallReferrerResponse.SERVICE_UNAVAILABLE -> {
                    }
                }
            }

            override fun onInstallReferrerServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
            }
        })
    }
}
