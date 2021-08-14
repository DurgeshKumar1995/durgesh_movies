package com.lowe.movies.repository

import com.lowe.movies.dataSource.BaseModel
import kotlinx.coroutines.Deferred

/*
* NetworkRepository for handle rest api data add share to Movie list view model
* */
interface NetworkRepository {

    //return  network data response with Deferred
    fun getMoviesListAsync(): Deferred<BaseModel>
}
