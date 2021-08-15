package com.lowe.movies.network

import com.lowe.movies.BuildConfig
import com.lowe.movies.dataSource.BaseModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
/*
* Retrofit interface
*
* all network api method entry
* */
interface RESTApi {

    /*
    * Get type request
    * @param key , request api required api-key for authentication
    *
    * @return Deferred data response
    * */
    @GET("reviews/search.json")
    suspend fun getMoviesListAsync(@Query("api-key") key: String = BuildConfig.API_KEY): BaseModel
}
