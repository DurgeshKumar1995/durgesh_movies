package com.lowe.movies.dataSource

/**
 *  multiple params.
 *
 * @param copyright copyright of the baseModel
 * @param has_more status of count element
 * @param num_results total number of Result count
 * @param results total movies list
 * @param status response status
 */
data class BaseModel(
    val copyright: String? = null,
    val has_more: Boolean? = null,
    val num_results: Int? = null,
    val results: ArrayList<Result>? = null,
    val status: String? = null
)
