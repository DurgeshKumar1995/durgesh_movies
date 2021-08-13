package com.lowe.movies.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

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
