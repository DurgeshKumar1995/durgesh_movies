package com.lowe.movies.network

import com.lowe.movies.BuildConfig
import com.lowe.movies.dataSource.BaseModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RESTApi {

    @GET("reviews/search.json")
    fun getMoviesListAsync(@Query("api-key") key: String = BuildConfig.API_KEY): Deferred<BaseModel>

}
