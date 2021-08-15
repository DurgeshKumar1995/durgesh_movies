package com.lowe.movies.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/*
* Store network response in cache
* To avoid network api hit on server
* request send then check in cache if available on cache then return response from cache
* If cache miss then hit api on server if network is connected and store data on cache
* return data on model
* */
class CacheInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest: Request = chain.request()
        val headerCacheKey = "Cache-Control"
        val cacheHeaderValue = if (NetworkUtil.isInternetAvailable(context)) "public, max-age=2419200" else "public, only-if-cached, max-stale=2419200"
        val request: Request = originalRequest.newBuilder().build()
        val response = chain.proceed(request)
        return response.newBuilder()
            .removeHeader("Pragma")
            .removeHeader(headerCacheKey)
            .header(headerCacheKey, cacheHeaderValue)
            .build()
    }
}
