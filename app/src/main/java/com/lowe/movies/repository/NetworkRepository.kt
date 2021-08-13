package com.lowe.movies.repository

import com.lowe.movies.dataSource.BaseModel
import kotlinx.coroutines.Deferred

interface NetworkRepository {

    fun getMoviesListAsync(): Deferred<BaseModel>
}
