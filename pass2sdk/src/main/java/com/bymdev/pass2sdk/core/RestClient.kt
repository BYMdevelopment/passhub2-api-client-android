package com.bymdev.pass2sdk.core

import android.content.Context

class RestClient {

    companion object {
        @Volatile
        private lateinit var instance: RestClient
        private lateinit var restApi: RestApi
        private lateinit var restAdapter: IRestAdapter

        fun getInstance(context: Context): RestClient {
            restAdapter = RestAdapter(context)
            restApi = restAdapter.createApi(RestApi::class.java)

            var localInstance: RestClient? = null
            if (localInstance == null) {
                synchronized(RestClient::class.java) {
                    if (localInstance == null) {
                        localInstance = RestClient()
                        instance = localInstance as RestClient
                    }
                }
            }
            return instance
        }

    }

    fun getService(): RestApi {
        return restApi
    }

}