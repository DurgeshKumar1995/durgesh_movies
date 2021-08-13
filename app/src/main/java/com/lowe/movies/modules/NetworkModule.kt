package com.lowe.movies.modules

import android.app.Application
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.lowe.movies.BuildConfig
import com.lowe.movies.network.CacheInterceptor
import com.lowe.movies.network.RESTApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object NetworkModule {

    private const val waitTimeOut: Long = 30
    private const val connTimeOut: Long = 10

    val networkModule = module {

        single(named(okHttp)) { provideDefaultOkhttpClient(androidApplication()) }

        single(named(retrofit)) { provideRetrofit(get(named(okHttp))) }

        single { provideTmdbService(get(named(retrofit))) }
    }

    fun provideDefaultOkhttpClient(app: Application): OkHttpClient {

        val cacheDir = File(app.cacheDir, cache)
        val size: Long = 10 * 1024 * 1024
        val cache = Cache(cacheDir, size)

        return if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.HEADERS
            logging.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(CacheInterceptor(app))
                .addNetworkInterceptor(logging)
                .addNetworkInterceptor(CacheInterceptor(app))
                .callTimeout(waitTimeOut, TimeUnit.SECONDS)
                .connectTimeout(connTimeOut, TimeUnit.SECONDS)
                .readTimeout(waitTimeOut, TimeUnit.SECONDS)
                .build()

        } else {
            OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(CacheInterceptor(app))
                .addNetworkInterceptor(CacheInterceptor(app))
                .callTimeout(waitTimeOut, TimeUnit.SECONDS)
                .connectTimeout(connTimeOut, TimeUnit.SECONDS)
                .readTimeout(waitTimeOut, TimeUnit.SECONDS)
                .build()

        }
    }

    fun gson() = GsonBuilder()
        .create()

    fun provideRetrofit(client: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BaseURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    }

    fun provideTmdbService(retrofit: Retrofit): RESTApi = retrofit.create(RESTApi::class.java)

    private const val okHttp = "okHttp"
    private const val retrofit = "retrofit"
    private const val cache = "network_cache"
}
