package com.lowe.movies.repository

import com.lowe.movies.dataSource.BaseModel

/*
* NetworkRepository for handle rest api data add share to Movie list view model
* */
interface NetworkRepository {

    // return  network data response with Deferred
    suspend fun getMoviesListAsync(): BaseModel
}
