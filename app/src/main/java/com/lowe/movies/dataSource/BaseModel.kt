package com.lowe.movies.dataSource

data class BaseModel(
    val copyright: String? = null,
    val has_more: Boolean? = null,
    val num_results: Int? = null,
    val results: ArrayList<Result>? = null,
    val status: String? = null
)