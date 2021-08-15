package com.lowe.movies.repository

import com.lowe.movies.dataSource.BaseModel

interface FakeNetworkRepository{
    suspend fun getMoviesListAsync(): BaseModel
}