package com.lowe.movies.impl

import com.lowe.movies.dataSource.BaseModel
import com.lowe.movies.network.RESTApi
import com.lowe.movies.repository.NetworkRepository
import kotlinx.coroutines.Deferred

class NetworkImpl(private val restApi: RESTApi) : NetworkRepository {
    override fun getMoviesListAsync(): Deferred<BaseModel> = restApi.getMoviesListAsync()
}
