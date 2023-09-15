package com.example.codechallenge.data.source.remote

import android.os.Build
import android.os.LocaleList
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.inject.Inject

class AppInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newBuilder = original.newBuilder()

        val accessToken: String? = runBlocking {
            if (original.header("Device-Authentication") == null) {
                ""
//                userDataSource.getUserToken()
            } else {
                ""
//                storeDataSource.getStoreToken()
        }}
        if (original.header("Authorization") == null && original.header("No-Authentication") == null) {

            accessToken?.let {
                newBuilder
                    .header("Authorization", "Bearer $it")
                    .build()
            }
        }

        runBlocking {
//            storeDataSource.getStoreTenantId()?.let {
//                newBuilder.addHeader("x-tenant-id", it)
//            }
        }



//        newBuilder.addHeader("Accept-Language", getCurrentLanguage())
        newBuilder.addHeader("x-device-platform", "android")
        newBuilder.addHeader("Accept", "application/json")

        return if (original.header("ignore-headers") != null) {
            val request = original.newBuilder().build()
            chain.proceed(request)
        } else {
            val request = newBuilder.build()
            chain.proceed(request)
        }

    }

//    private fun getCurrentLanguage(): String {
//        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            LocaleList.getDefault()[0].language
//        } else {
//            Locale.getDefault().language
//        }
//    }
}