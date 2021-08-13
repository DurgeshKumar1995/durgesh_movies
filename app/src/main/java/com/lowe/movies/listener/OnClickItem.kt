package com.lowe.movies.listener

interface OnClickItem<T> {
    fun onClick(t: T? = null)
}
