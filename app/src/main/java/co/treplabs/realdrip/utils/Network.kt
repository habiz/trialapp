package co.treplabs.realdrip.utils


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

import java.io.IOException
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

object Network {
    @Throws(IOException::class)
    fun makePostRequest(URL: String, body: RequestBody): Call {
        val client = OkHttpClient()

        val request = Request.Builder()
                .url(URL)
                .post(body)
                .build()

        return client.newCall(request)

    }

    @Throws(IOException::class)
    fun makeGetRequest(URL: String): Call {
        val client = OkHttpClient()
        return client.newCall(Request.Builder()
                .url(URL)
                .get()
                .build())
    }

    @Throws(IOException::class)
    fun makeDeleteRequest(URL: String): Call {
        val client = OkHttpClient()
        return client.newCall(Request.Builder()
            .url(URL)
            .delete()
            .build())
    }

}
