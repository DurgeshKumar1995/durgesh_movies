package com.lowe.movies.impl

import com.lowe.movies.dataSource.BaseModel
import com.lowe.movies.network.RESTApi
import com.lowe.movies.repository.NetworkRepository

/*
* Network call impl of Network repository
* Add retrofit rest api interface
* @param restApi restApi for retrofit interface instance
 */
class NetworkImpl(private val restApi: RESTApi) : NetworkRepository {

    /*
    * NetworkRepository implemented function
     * @return network response with Deferred
     */
    override suspend fun getMoviesListAsync(): BaseModel = restApi.getMoviesListAsync()
}
