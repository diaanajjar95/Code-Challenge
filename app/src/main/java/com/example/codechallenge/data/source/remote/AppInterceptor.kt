package com.example.codechallenge.data.source.remote

import com.example.codechallenge.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AppInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val httpUrl = original.url
        val newHttpUrl =
            httpUrl.newBuilder().addQueryParameter("api-key", BuildConfig.API_KEY).build()
        val newRequestBuilder = original.newBuilder().url(newHttpUrl)
        val newRequest = newRequestBuilder.build()
        return chain.proceed(newRequest)
    }
}